package annotation;

public class Override_ {
    // 使用 @Override 注解来标记方法重写
    @Override
    public String toString() {
        return "This is an example of @Override annotation.";
    }

    public static void main(String[] args) {
        Override_ example = new Override_();
        System.out.println(example.toString());
    }
}
