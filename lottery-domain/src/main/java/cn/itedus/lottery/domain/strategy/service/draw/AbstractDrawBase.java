package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.aggregrates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vikingar
 * @time 2024/3/19 19:26
 * @description 定义抽象抽奖过程，模板模式
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{

    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 1. 获取抽奖策略和数据
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();

        // 2. 检测是否初始化概率元组
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // 3. 排除不在抽奖范围内的信息
        List<String> excludeList = this.queryExcludeAwardIds(req.getStrategyId());

        // 4. 执行抽奖算法
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()), excludeList);

        // 5. 包装返回抽奖结果
        return buildDrawResult(req.getuId(), req.getStrategyId(), awardId);
    }

    /**
     * 定义 DrawResult 返回结果
     * @param uId user id
     * @param strategyId 策略id
     * @param awardId 奖品id
     * @return
     */
    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {
        if (null == awardId) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }
        Award award = super.queryAwardInfo(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardName());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }

    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm iDrawAlgorithm, List<String> excludeList);

    /**
     * 获取排除的奖品信息
     * @param strategyId 策略id
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 检测抽奖策略是否初始化到内存
     * @param strategyId 策略id
     * @param strategyMode 策略模式
     * @param strategyDetailList 策略详情信息
     */
    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {

        // 非单项概率，不用初始化到内存
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) return;

        // 已经初始化的数据不用再初始化
        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);
        if (drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        // 解析并初始化中奖概率到散列表
        List<AwardRateInfo> awardArrayList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardArrayList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardArrayList);

    }
}
