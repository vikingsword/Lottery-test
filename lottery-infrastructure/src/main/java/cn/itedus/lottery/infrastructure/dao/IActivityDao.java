package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vikingar
 * @time 2024/3/15 22:29
 * @description
 */
@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long id);

    int alterStatus(AlterStateVO alterStateVO);


}
