package cn.itedus.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author vikingar
 * @time 2024/3/15 23:26
 * @description
 */
public class ActivityReq implements Serializable {

    private Long activityId;

    public ActivityReq(Long activityId) {
        this.activityId = activityId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}
