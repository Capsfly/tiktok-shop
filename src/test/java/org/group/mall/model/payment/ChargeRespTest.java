package org.group.mall.model.payment;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ChargeRespTest {

    @Test
    void testSuccess() {
        // 准备测试数据
        String transactionId = "tx123";
        String orderId = "order456";
        BigDecimal amount = new BigDecimal("100.00");
        String paymentMethod = "CREDIT_CARD";

        // 调用 success 方法
        ChargeResp resp = ChargeResp.success(transactionId, orderId, amount, paymentMethod);

        // 断言返回结果正确
        assertNotNull(resp, "返回对象不应为空");
        assertEquals("SUCCESS", resp.getStatus(), "状态应该为 SUCCESS");
        assertEquals(transactionId, resp.getTransactionId(), "transactionId 不匹配");
        assertEquals(orderId, resp.getOrderId(), "orderId 不匹配");
        assertEquals(amount, resp.getAmount(), "amount 不匹配");
        assertEquals(paymentMethod, resp.getPaymentMethod(), "paymentMethod 不匹配");
        assertNotNull(resp.getTimestamp(), "timestamp 不应为空");
        // success 方法中未设置 errorCode 和 errorMessage
        assertEquals(0, resp.getErrorCode(), "errorCode 默认值应为 0");
        assertNull(resp.getErrorMessage(), "errorMessage 应为 null");
    }

    @Test
    void testFailure() {
        // 准备测试数据
        int errorCode = 404;
        String errorMessage = "Not Found";
        String orderId = "order789";
        BigDecimal amount = new BigDecimal("50.00");

        // 调用 failure 方法
        ChargeResp resp = ChargeResp.failure(errorCode, errorMessage, orderId, amount);

        // 断言返回结果正确
        assertNotNull(resp, "返回对象不应为空");
        assertEquals("FAILED", resp.getStatus(), "状态应该为 FAILED");
        assertEquals(errorCode, resp.getErrorCode(), "errorCode 不匹配");
        assertEquals(errorMessage, resp.getErrorMessage(), "errorMessage 不匹配");
        assertEquals(orderId, resp.getOrderId(), "orderId 不匹配");
        assertEquals(amount, resp.getAmount(), "amount 不匹配");
        assertNotNull(resp.getTimestamp(), "timestamp 不应为空");
        // failure 方法中未设置 transactionId 和 paymentMethod
        assertNull(resp.getTransactionId(), "transactionId 应为 null");
        assertNull(resp.getPaymentMethod(), "paymentMethod 应为 null");
    }
}