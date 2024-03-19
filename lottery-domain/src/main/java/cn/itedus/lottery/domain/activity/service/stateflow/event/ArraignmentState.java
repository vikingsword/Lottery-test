package cn.itedus.lottery.domain.activity.service.stateflow.event;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @author vikingar
 * @time 2024/3/19 23:28
 * @description
 */
@Component
public class ArraignmentState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildErrorResult("待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean flag = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.PASS);
        return flag ? Result.buildSuccessResult("审核铜鼓") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean flag = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return flag ? Result.buildSuccessResult("活动审核拒绝完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean flag = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return flag ? Result.buildSuccessResult("活动审核撤销回到编辑中") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean flag = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return flag ? Result.buildSuccessResult("活动审核关闭完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildErrorResult("非关闭活动不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildErrorResult("待审核活动不可执行活动中变更");
    }
}
