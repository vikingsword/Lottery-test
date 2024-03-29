package cn.itedus.lottery.domain.support.ids.ploicy;

import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @author vikingar
 * @time 2024/3/21 15:10
 * @description 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 */
@Component
public class ShortCode implements IIdGenerator {

    @Override
    public long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
        StringBuilder builder = new StringBuilder();
        builder.append(year - 2020);
        builder.append(hour);
        builder.append(String.format("%02d", week));
        builder.append(day);
        builder.append(String.format("%02d", new Random().nextInt(1000)));

        return Long.parseLong(builder.toString());

    }
}
