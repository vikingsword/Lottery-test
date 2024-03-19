package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.aggregrates.StrategyRich;
import cn.itedus.lottery.domain.strategy.repo.IStrategyRepository;
import cn.itedus.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/3/19 19:18
 * @description
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    protected Award queryAwardInfo(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}
