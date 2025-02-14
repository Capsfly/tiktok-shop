package org.group.mall.utils;

import org.apache.commons.validator.routines.CreditCardValidator;

public class CreditCardUtil {
    private static final CreditCardValidator validator = new CreditCardValidator();

    public static boolean isValidCardNumber(String cardNumber,String cvv) {
        return validator.isValid(cardNumber) && isValidCVV(cvv,cardNumber);
    }

    public static boolean isValidCVV(String cvv, String cardNumber) {
        if (cvv == null || !cvv.matches("\\d{3,4}")) {
            return false;
        }

        if (cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
            return cvv.length() == 4;
        }
        return cvv.length() == 3;
    }


}
