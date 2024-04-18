package test;

import java.util.Random;

public class OTP {
    public static void main(String[] args) {
        String otp = generateOTP(5);
    }

    private static String generateOTP(int lenght) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            sb.append(random.nextInt(10));
        }
        String otp = sb.toString();
        return otp;
    }
}
