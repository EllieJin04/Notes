package commonly_used_class.homework;


// homework3
public class FormatName {
    public static void main(String[] args) {
        String name = formatName("William Jefferson Clinton");
        System.out.println(name);
    }

    /**
     * 编写方法: 完成输出格式要求的字符串
     * 编写java程序，输入形式为： William Jefferson Clinton的人名，以Clinton, William .J的形式打印出来
     * 其中.J是中间单词的首字母
     * @param name
     * @return
     */
    public static String formatName(String name) {
        if (name == null) {
            return "";
        }

        String[] split = name.split(" ");
        if (split.length != 3) {
            throw new IllegalArgumentException("Illegal Name.");
        }
        return split[2] + ", " + split[0] + " ." + split[1].charAt(0);
    }
}
