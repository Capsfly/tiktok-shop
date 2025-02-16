package org.group.mall.constant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorCodeTest {

    @Test
    void testEnumValues() {
        // 确保 ErrorCode 包含正确的枚举值
        //assertEquals(1,0);
        assertEquals(6, ErrorCode.values().length);
        assertNotNull(ErrorCode.INVALID_INPUT);
        assertNotNull(ErrorCode.PAYMENT_FAILED);
        assertNotNull(ErrorCode.INSUFFICIENT_FUNDS);
        assertNotNull(ErrorCode.CREDITCARD_INFO_FAIL);
        assertNotNull(ErrorCode.UNAUTHORIZED);
        assertNotNull(ErrorCode.SYSTEM_ERROR);
    }

    @Test
    void testGetCode() {
        // 确保 getCode() 返回正确的数值
        assertEquals(1001, ErrorCode.INVALID_INPUT.getCode());
        assertEquals(2001, ErrorCode.PAYMENT_FAILED.getCode());
        assertEquals(2002, ErrorCode.INSUFFICIENT_FUNDS.getCode());
        assertEquals(2003, ErrorCode.CREDITCARD_INFO_FAIL.getCode());
        assertEquals(3001, ErrorCode.UNAUTHORIZED.getCode());
        assertEquals(5000, ErrorCode.SYSTEM_ERROR.getCode());
    }

    @Test
    void testGetMessage() {
        // 确保 getMessage() 返回正确的错误信息
        assertEquals("输入参数无效", ErrorCode.INVALID_INPUT.getMessage());
        assertEquals("支付失败", ErrorCode.PAYMENT_FAILED.getMessage());
        assertEquals("余额不足", ErrorCode.INSUFFICIENT_FUNDS.getMessage());
        assertEquals("银行卡信息校验失败", ErrorCode.CREDITCARD_INFO_FAIL.getMessage());
        assertEquals("未授权访问", ErrorCode.UNAUTHORIZED.getMessage());
        assertEquals("系统内部错误", ErrorCode.SYSTEM_ERROR.getMessage());
    }

    @Test
    void testGetMessageByCode() {
        // 确保 getMessageByCode() 方法返回正确的错误信息
        assertEquals("输入参数无效", ErrorCode.getMessageByCode(1001));
        assertEquals("支付失败", ErrorCode.getMessageByCode(2001));
        assertEquals("余额不足", ErrorCode.getMessageByCode(2002));
        assertEquals("银行卡信息校验失败", ErrorCode.getMessageByCode(2003));
        assertEquals("未授权访问", ErrorCode.getMessageByCode(3001));
        assertEquals("系统内部错误", ErrorCode.getMessageByCode(5000));

        // 测试未知错误码
        assertEquals("未知错误", ErrorCode.getMessageByCode(9999));
    }

    @Test
    void testValueOf() {
        // 确保 valueOf() 方法正确解析枚举名
        assertEquals(ErrorCode.INVALID_INPUT, ErrorCode.valueOf("INVALID_INPUT"));
        assertEquals(ErrorCode.PAYMENT_FAILED, ErrorCode.valueOf("PAYMENT_FAILED"));
        assertEquals(ErrorCode.INSUFFICIENT_FUNDS, ErrorCode.valueOf("INSUFFICIENT_FUNDS"));
        assertEquals(ErrorCode.CREDITCARD_INFO_FAIL, ErrorCode.valueOf("CREDITCARD_INFO_FAIL"));
        assertEquals(ErrorCode.UNAUTHORIZED, ErrorCode.valueOf("UNAUTHORIZED"));
        assertEquals(ErrorCode.SYSTEM_ERROR, ErrorCode.valueOf("SYSTEM_ERROR"));
    }

    @Test
    void testInvalidValueOf() {
        // 确保 valueOf() 方法解析非法字符串时抛出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> ErrorCode.valueOf("INVALID_CODE"));
    }
}