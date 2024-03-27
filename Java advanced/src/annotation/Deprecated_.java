package annotation;

public class Deprecated_ {
    // 使用 @Deprecated 注解来标记已过时的方法
    @Deprecated
    public void deprecatedMethod() {
        System.out.println("This method is deprecated.");
    }

    public static void main(String[] args) {
        Deprecated_ example = new Deprecated_();
        // 调用已过时的方法会触发编译器警告
        example.deprecatedMethod();
    }
}
