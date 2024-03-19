package cn.itedus.lottery.domain.activity.service.deploy;

import cn.itedus.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @author vikingar
 * @time 2024/3/20 0:18
 * @description
 */
public interface IActivityDeploy {

    void createActivity(ActivityConfigReq req);


    void updateActivity(ActivityConfigReq req);
}
