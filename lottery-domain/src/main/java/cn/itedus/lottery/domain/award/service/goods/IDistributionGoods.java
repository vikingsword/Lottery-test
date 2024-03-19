package cn.itedus.lottery.domain.award.service.goods;

import cn.itedus.lottery.domain.award.model.req.GoodReq;
import cn.itedus.lottery.domain.award.model.res.DistributionRes;

/**
 * @author vikingar
 * @time 2024/3/19 18:20
 * @description
 */
public interface IDistributionGoods {

    DistributionRes doDistribution(GoodReq req);


    Integer getDistributionGoodsName();
}
