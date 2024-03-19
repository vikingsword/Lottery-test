package cn.itedus.lottery.domain.award.service.facotry;

import cn.itedus.lottery.domain.award.repo.IAwardRepository;
import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/3/19 18:39
 * @description goods factory
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{


    @Resource
    private IAwardRepository awardRepository;


    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }

}
