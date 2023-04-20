package org.example.app.utils;

// Валидация password
public class PassValidator {
    public static boolean isPassValid(String pass) {
        return pass.isEmpty() || !pass.matches(Constants.PASS_RGX);
    }
}
