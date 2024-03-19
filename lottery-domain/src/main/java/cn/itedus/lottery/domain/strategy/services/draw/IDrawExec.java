package cn.itedus.lottery.domain.strategy.services.draw;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author vikingar
 * @time 2024/3/16 23:40
 * @description 策略包装
 */
public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);

}
