package annotation;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarnings_ {
    // 使用 @SuppressWarnings_ 注解来抑制未检查的警告
    // @SuppressWarnings("all")
    @SuppressWarnings("unused")
    public void exampleMethod() {
        // 假设这里有一个未经检查的警告
        // 我们使用 @SuppressWarnings_("unused") 来忽略它
        // 这样可以让编译器不再报未检查的警告
        List<String> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        SuppressWarnings_ example = new SuppressWarnings_();
        example.exampleMethod();
    }
}
