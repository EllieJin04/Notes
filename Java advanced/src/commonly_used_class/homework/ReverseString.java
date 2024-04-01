package commonly_used_class.homework;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcdefghijk";
        System.out.println(reverse(str, 2, 7));
    }

    /*
        将字符串str的指定位置进行翻转，从start到end结束。
     */
    public static String reverse(String str, int start, int end) {
        StringBuilder sb = new StringBuilder(str.substring(0, start));
        for (int i = end; i >= start; i--) {
            sb.append(str.charAt(i));
        }
        if (end != str.length() - 1) {
            sb.append(str.substring(end + 1));
        }
        return sb.toString();
    }
}
