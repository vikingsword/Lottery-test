package cn.itedus.lottery.domain.strategy.services.draw;

import cn.itedus.lottery.domain.strategy.services.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.services.algorithm.impl.DefaultRateRandomDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.services.algorithm.impl.SingleRateRandomDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vikingar
 * @time 2024/3/16 23:41
 * @description
 */
public class DrawConfig {

    @Resource
    private DefaultRateRandomDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private SingleRateRandomDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }

}
