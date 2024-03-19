package cn.itedus.lottery.rpc.res;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @author vikingar
 * @time 2024/3/15 23:25
 * @description
 */
public class ActivityRes implements Serializable {

    private Result result;
    private ActivityDto activityDto;

    public ActivityRes() {
        this.result = result;
        this.activityDto = activityDto;
    }

    public ActivityRes(Result result, ActivityDto activityDto) {
        this.result = result;
        this.activityDto = activityDto;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivityDto() {
        return activityDto;
    }

    public void setActivityDto(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }
}
