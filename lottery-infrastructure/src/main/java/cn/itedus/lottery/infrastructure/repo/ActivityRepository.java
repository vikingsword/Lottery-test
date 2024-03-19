package cn.itedus.lottery.infrastructure.repo;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.domain.activity.repo.IActivityRepository;
import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author vikingar
 * @time 2024/3/19 23:51
 * @description
 */
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        Integer beforeCode = ((Constants.ActivityState) beforeState).getCode();
        Integer afterCode = ((Constants.ActivityState) afterState).getCode();
        AlterStateVO alterStateVO = new AlterStateVO(activityId, beforeCode, afterCode);
        int count = activityDao.alterStatus(alterStateVO);
        return count == 1;
    }

    @Override
    public void addActivity(ActivityVO activity) {

    }
}
