package cn.itedus.lottery.domain.support.ids.ploicy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author vikingar
 * @time 2024/3/21 15:10
 * @description hutool 工具包下的雪花算法
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowflake;

    @PostConstruct
    public void inti() {
        long workId;
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workId = NetUtil.getLocalhostStr().hashCode();
        }

        workId = workId >> 16 & 31;

        long dataCenterId = 1L;
        snowflake = IdUtil.createSnowflake(workId, dataCenterId);
    }
    @Override
    public synchronized long nextId() {
        return snowflake.nextId();
    }

}
