package com.minhpt.bot.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class BotTelegramUtil {
    public static String OTP(int len) {
        // Using numeric values
        String numbers = "0123456789";
        // Using random method
        Random rndm_method = new Random();

        StringBuilder otpString = new StringBuilder();
        for (int i = 0; i < len; i++) {
            otpString.append(numbers.charAt(rndm_method.nextInt(numbers.length())));
        }
        return otpString.toString();
    }
    public static String checkStringNull(String string){
        return StringUtils.isNotBlank(string) ? string : "";
    }
}
