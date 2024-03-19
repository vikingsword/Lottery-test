package cn.itedus.lottery.domain.activity.repo;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;

/**
 * @author vikingar
 * @time 2024/3/19 23:26
 * @description
 */
public interface IActivityRepository {

    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> currentState, Enum<Constants.ActivityState> activityState);


    void addActivity(ActivityVO activity);
}
