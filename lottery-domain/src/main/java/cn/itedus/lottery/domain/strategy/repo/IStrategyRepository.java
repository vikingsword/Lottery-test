package cn.itedus.lottery.domain.strategy.repo;

import cn.itedus.lottery.domain.strategy.model.aggregrates.StrategyRich;
import cn.itedus.lottery.infrastructure.po.Award;

/**
 * @author vikingar
 * @time 2024/3/16 22:27
 * @description
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);
}
