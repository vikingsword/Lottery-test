package cn.itedus.lottery.domain.strategy.service.algorithm;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/**
 * @author vikingar
 * @time 2024/3/16 22:30
 * @description
 */
public interface IDrawAlgorithm {

    /**
     * 初始化概率数组
     * @param strategyId 策略id
     * @param awardRateInfoList 奖品概率信息
     */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);


    /**
     * 判断是否存在概率数组
     * @param strategyId 策略id
     * @return boolean
     */
    boolean isExistRateTuple(Long strategyId);


    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId 策略ID
     * @param excludeAwardIds 排除掉已经不能作为抽奖的奖品ID，留给风控和空库存使用
     * @return 中奖结果
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}
