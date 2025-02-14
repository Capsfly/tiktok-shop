package org.group.mall.utils;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowflakeUtil {
    private static final Snowflake SNOWFLAKE = IdUtil.getSnowflake(1, 1); // 机器 ID 和数据中心 ID

    public static long nextId() {
        return SNOWFLAKE.nextId();
    }
}

