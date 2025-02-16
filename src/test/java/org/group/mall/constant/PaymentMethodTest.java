package org.group.mall.constant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodTest {

    @Test
    void testEnumValues() {
        // 确保 PaymentMethod 包含正确的枚举值
        assertEquals(4, PaymentMethod.values().length);
        assertNotNull(PaymentMethod.ALIPAY);
        assertNotNull(PaymentMethod.WECHAT_PAY);
        assertNotNull(PaymentMethod.CREDIT_CARD);
        assertNotNull(PaymentMethod.PAYPAL);
    }

    @Test
    void testGetCode() {
        // 确保 getCode() 返回正确的支付方式编码
        assertEquals("ALIPAY", PaymentMethod.ALIPAY.getCode());
        assertEquals("WECHAT_PAY", PaymentMethod.WECHAT_PAY.getCode());
        assertEquals("CREDIT_CARD", PaymentMethod.CREDIT_CARD.getCode());
        assertEquals("PAYPAL", PaymentMethod.PAYPAL.getCode());
    }

    @Test
    void testGetDescription() {
        // 确保 getDescription() 返回正确的支付方式描述
        assertEquals("支付宝", PaymentMethod.ALIPAY.getDescription());
        assertEquals("微信支付", PaymentMethod.WECHAT_PAY.getDescription());
        assertEquals("信用卡支付", PaymentMethod.CREDIT_CARD.getDescription());
        assertEquals("PayPal 支付", PaymentMethod.PAYPAL.getDescription());
    }

    @Test
    void testFromCode() {
        // 确保 fromCode() 能正确解析支付方式编码
        assertEquals(PaymentMethod.ALIPAY, PaymentMethod.fromCode("ALIPAY"));
        assertEquals(PaymentMethod.WECHAT_PAY, PaymentMethod.fromCode("WECHAT_PAY"));
        assertEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.fromCode("CREDIT_CARD"));
        assertEquals(PaymentMethod.PAYPAL, PaymentMethod.fromCode("PAYPAL"));

        // 测试忽略大小写
        assertEquals(PaymentMethod.ALIPAY, PaymentMethod.fromCode("alipay"));
        assertEquals(PaymentMethod.WECHAT_PAY, PaymentMethod.fromCode("wechat_pay"));
        assertEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.fromCode("credit_card"));
        assertEquals(PaymentMethod.PAYPAL, PaymentMethod.fromCode("paypal"));
    }

    @Test
    void testInvalidFromCode() {
        // 确保 fromCode() 解析非法支付方式时抛出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> PaymentMethod.fromCode("INVALID_METHOD"));
        assertThrows(IllegalArgumentException.class, () -> PaymentMethod.fromCode(""));
        assertThrows(IllegalArgumentException.class, () -> PaymentMethod.fromCode(null));
    }

    @Test
    void testValueOf() {
        // 确保 valueOf() 能正确解析字符串为枚举值
        assertEquals(PaymentMethod.ALIPAY, PaymentMethod.valueOf("ALIPAY"));
        assertEquals(PaymentMethod.WECHAT_PAY, PaymentMethod.valueOf("WECHAT_PAY"));
        assertEquals(PaymentMethod.CREDIT_CARD, PaymentMethod.valueOf("CREDIT_CARD"));
        assertEquals(PaymentMethod.PAYPAL, PaymentMethod.valueOf("PAYPAL"));
    }

    @Test
    void testInvalidValueOf() {
        // 确保 valueOf() 解析非法字符串时抛出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> PaymentMethod.valueOf("INVALID_ENUM"));
    }
}