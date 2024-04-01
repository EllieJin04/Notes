package commonly_used_class.homework;

// homework2
public class Register {

    /**
     * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
     * 要求：
     * (1) 用户名长度为2或3或4
     * (2) 密码的长度为6，要求全是数字  isDigital
     * (3) 邮箱中包含@和.   并且@在.的前面
     */
    public static void main(String[] args) {
        register("wer", "123456", "123@qq.com");
        // register("wer12", "123456", "123@qq.com");
//        register("wer1", "1234567", "123@qq.com");
//        register("123", "123dff", "123@qq.com");
        register("wer", "123456", "123.@com");
    }

    public static void register(String username, String password, String email) {
        // username check
        if (username.length() < 2 || username.length() > 4) {
            throw new IllegalArgumentException("Illegal username. The length of username should be between 2 and 4");
        }

        // password check
        if (password.length() != 6) {
            throw new IllegalArgumentException("Illegal password. The length of password should be 6.");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isDigit(password.charAt(i))) {
                throw new IllegalArgumentException("Illegal password. Password should be all digits.");
            }
        }

        // email check
        if (!(email.contains("@") && email.contains(".") && email.indexOf('@') < email.indexOf('.'))) {
            throw new IllegalArgumentException("Illegal email.");
        }

        System.out.println("Register completed!");

    }
}
