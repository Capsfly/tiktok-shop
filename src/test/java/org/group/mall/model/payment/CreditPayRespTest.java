package org.group.mall.model.payment;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditPayRespTest {

    @Test
    void testSuccess() {
        // 准备测试数据
        String transactionId = "txn123";
        String orderId = "order001";
        BigDecimal amount = new BigDecimal("100.00");

        // 调用 success 方法生成成功响应
        CreditPayResp resp = CreditPayResp.success(transactionId, orderId, amount);

        // 验证返回结果
        assertNotNull(resp, "返回对象不应为空");
        assertEquals(transactionId, resp.getTransactionId(), "transactionId 不匹配");
        assertEquals(orderId, resp.getOrderId(), "orderId 不匹配");
        assertEquals(amount, resp.getAmount(), "amount 不匹配");
        assertEquals("SUCCESS", resp.getPaymentStatus(), "paymentStatus 应为 SUCCESS");
        assertNotNull(resp.getTimestamp(), "timestamp 不应为空");

        // success 方法未设置错误信息，默认应为 null
        assertNull(resp.getErrorCode(), "errorCode 应为 null");
        assertNull(resp.getErrorMessage(), "errorMessage 应为 null");
    }

    @Test
    void testFailure() {
        // 准备测试数据
        String errorCode = "ERR001";
        String errorMessage = "Insufficient funds";
        String orderId = "order002";
        BigDecimal amount = new BigDecimal("200.00");

        // 调用 failure 方法生成失败响应
        CreditPayResp resp = CreditPayResp.failure(errorCode, errorMessage, orderId, amount);

        // 验证返回结果
        assertNotNull(resp, "返回对象不应为空");
        assertEquals(orderId, resp.getOrderId(), "orderId 不匹配");
        assertEquals(amount, resp.getAmount(), "amount 不匹配");
        assertEquals("FAIL", resp.getPaymentStatus(), "paymentStatus 应为 FAIL");
        assertEquals(errorCode, resp.getErrorCode(), "errorCode 不匹配");
        assertEquals(errorMessage, resp.getErrorMessage(), "errorMessage 不匹配");
        assertNotNull(resp.getTimestamp(), "timestamp 不应为空");

        // failure 方法中未设置 transactionId
        assertNull(resp.getTransactionId(), "transactionId 应为 null");
    }
}