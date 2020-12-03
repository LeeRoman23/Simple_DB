public class PasswordBuilder {

    private static String chars = "ABCDEFGHIKLMNOPQRSTVXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
    private static String newPassword = "";

    public static String createPassword() {
        for (int i = 0; i < 10; i++) {
            char word = chars.charAt((int)(Math.random()*chars.length()));
            newPassword += word;
        }
        return newPassword;
    }
}
