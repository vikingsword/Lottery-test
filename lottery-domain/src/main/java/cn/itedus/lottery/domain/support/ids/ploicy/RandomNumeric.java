package cn.itedus.lottery.domain.support.ids.ploicy;

import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author vikingar
 * @time 2024/3/21 15:10
 * @description 工具类生成 org.apache.commons.lang3.RandomStringUtils
 */
@Component
public class RandomNumeric implements IIdGenerator {


    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
