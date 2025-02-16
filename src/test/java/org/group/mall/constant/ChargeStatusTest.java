package org.group.mall.constant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ChargeStatusTest {

    @Test
    void testEnumValues() {
        assertNotNull(ChargeStatus.SUCCESS);
        assertNotNull(ChargeStatus.FAILED);
        assertNotNull(ChargeStatus.PENDING);
    }

    @Test
    void testGetCode() {
        // 确保 getCode() 返回正确的数值
        assertEquals(1001, ChargeStatus.SUCCESS.getCode());
        assertEquals(2001, ChargeStatus.FAILED.getCode());
        assertEquals(3001, ChargeStatus.PENDING.getCode());
    }

    @Test
    void testGetMessage() {
        // 确保 getMessage() 返回正确的文本
        assertEquals("付款成功", ChargeStatus.SUCCESS.getMessage());
        assertEquals("付款失败", ChargeStatus.FAILED.getMessage());
        assertEquals("PENDING", ChargeStatus.PENDING.getMessage());
    }

    @Test
    void testValueOf() {
        // 确保 valueOf() 能正确解析字符串为枚举值
        assertEquals(ChargeStatus.SUCCESS, ChargeStatus.valueOf("SUCCESS"));
        assertEquals(ChargeStatus.FAILED, ChargeStatus.valueOf("FAILED"));
        assertEquals(ChargeStatus.PENDING, ChargeStatus.valueOf("PENDING"));
    }

    @Test
    void testInvalidValueOf() {
        // 确保 valueOf() 解析非法值时抛出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> ChargeStatus.valueOf("INVALID"));
    }
}