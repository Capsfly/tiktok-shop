package org.group.mall.model.payment;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ChargeRespDTOTest {

    @Test
    void testFromSuccess() {
        // 准备成功的 ChargeResp 测试数据
        String transactionId = "tx001";
        String orderId = "order001";
        BigDecimal amount = new BigDecimal("200.00");
        String paymentMethod = "PAYPAL";

        // 使用 ChargeResp.success 方法生成成功响应
        ChargeResp chargeResp = ChargeResp.success(transactionId, orderId, amount, paymentMethod);

        // 调用转换方法
        ChargeRespDTO dto = ChargeRespDTO.from(chargeResp);

        // 验证转换结果
        assertEquals(transactionId, dto.getTransactionId(), "transactionId 不匹配");
        assertEquals("SUCCESS", dto.getStatus(), "状态不匹配");
        // 成功响应中 errorCode 和 errorMessage 未设置，默认为 null 或 0
        // 这里假设未设置时为 null，如果 ChargeResp 中默认为 0，可根据实际情况调整断言
        //assertNull(dto.getErrorCode(), "errorCode 应为 null");
        assertNull(dto.getErrorMessage(), "errorMessage 应为 null");
        assertNotNull(dto.getTimestamp(), "timestamp 不应为 null");
        assertEquals(orderId, dto.getOrderId(), "orderId 不匹配");
        assertEquals(amount, dto.getAmount(), "amount 不匹配");
        assertEquals(paymentMethod, dto.getPaymentMethod(), "paymentMethod 不匹配");
    }

    @Test
    void testFromFailure() {
        // 准备失败的 ChargeResp 测试数据
        int errorCode = 500;
        String errorMessage = "Internal Server Error";
        String orderId = "order002";
        BigDecimal amount = new BigDecimal("300.00");

        // 使用 ChargeResp.failure 方法生成失败响应
        ChargeResp chargeResp = ChargeResp.failure(errorCode, errorMessage, orderId, amount);

        // 调用转换方法
        ChargeRespDTO dto = ChargeRespDTO.from(chargeResp);

        // 验证转换结果
        // 失败响应中 transactionId 和 paymentMethod 未设置，应该为 null
        assertNull(dto.getTransactionId(), "transactionId 应为 null");
        assertEquals("FAILED", dto.getStatus(), "状态不匹配");
        // 注意：ChargeResp.failure 返回的 errorCode 为 int 类型，转换后可直接比对
        assertEquals(errorCode, dto.getErrorCode(), "errorCode 不匹配");
        assertEquals(errorMessage, dto.getErrorMessage(), "errorMessage 不匹配");
        assertNotNull(dto.getTimestamp(), "timestamp 不应为 null");
        assertEquals(orderId, dto.getOrderId(), "orderId 不匹配");
        assertEquals(amount, dto.getAmount(), "amount 不匹配");
        assertNull(dto.getPaymentMethod(), "paymentMethod 应为 null");
    }
}