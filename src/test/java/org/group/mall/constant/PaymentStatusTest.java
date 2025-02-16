package org.group.mall.constant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentStatusTest {

    @Test
    void testEnumValues() {
        // 确保 PaymentStatus 包含正确的枚举值
        assertEquals(3, PaymentStatus.values().length);
        assertNotNull(PaymentStatus.SUCCESS);
        assertNotNull(PaymentStatus.FAILED);
        assertNotNull(PaymentStatus.PENDING);
    }

    @Test
    void testGetCode() {
        // 确保 getCode() 返回正确的支付状态编码
        assertEquals("0000", PaymentStatus.SUCCESS.getCode());
        assertEquals("1000", PaymentStatus.FAILED.getCode());
        assertEquals("2000", PaymentStatus.PENDING.getCode());
    }

    @Test
    void testGetMessage() {
        // 确保 getMessage() 返回正确的支付状态描述
        assertEquals("支付成功", PaymentStatus.SUCCESS.getMessage());
        assertEquals("支付失败", PaymentStatus.FAILED.getMessage());
        assertEquals("支付处理中", PaymentStatus.PENDING.getMessage());
    }

    @Test
    void testValueOf() {
        // 确保 valueOf() 能正确解析字符串为枚举值
        assertEquals(PaymentStatus.SUCCESS, PaymentStatus.valueOf("SUCCESS"));
        assertEquals(PaymentStatus.FAILED, PaymentStatus.valueOf("FAILED"));
        assertEquals(PaymentStatus.PENDING, PaymentStatus.valueOf("PENDING"));
    }

    @Test
    void testInvalidValueOf() {
        // 确保 valueOf() 解析非法字符串时抛出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> PaymentStatus.valueOf("INVALID_STATUS"));
    }
}