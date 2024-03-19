package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vikingar
 * @time 2024/3/16 23:58
 * @description
 */
@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);
}
