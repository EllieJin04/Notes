package annotation;

/*
    Meta-Annotation，元注解，是一种特殊的注解，用于修饰其他注解。它们提供了关于注解自身的信息，例如注解的保留策略、作用目标等。
    Java 中有几种标准的元注解，包括 @Retention、@Target、@Documented 和 @Inherited。
    1. Retention（保留策略）：
        Retention 元注解用于指定注解的保留策略，即注解在何时保留。Java 定义了三种保留策略：
        SOURCE：注解仅保留在源代码中，编译器会忽略它们，不会包含在编译后的类文件中。
        CLASS：注解保留到编译后的类文件中，但在运行时不会被虚拟机加载。
        RUNTIME：注解保留到编译后的类文件中，并且在运行时可通过反射机制获取。大多数情况下，我们希望注解的保留策略为 RUNTIME，
        以便在运行时能够动态获取注解信息。

    2. Target（目标元素类型）：
        Target 元注解用于指定注解可以应用的目标元素类型。即，注解可以放置在哪些程序元素上。
        Java 定义了多个目标元素类型，包括类、接口、枚举、字段、方法、参数、构造方法和局部变量等。
        使用 Target 元注解可以限制注解的使用范围，提高注解的精确度和可读性。

    3. Documented（是否包含在 Javadoc 中）：
        Documented 元注解表示该注解是否包含在生成的 Javadoc 文档中。如果一个注解被标记为 Documented，
        则在使用该注解的地方会在 Javadoc 中显示该注解及其描述信息。Documented 是一个标记注解，不接收任何元素值。

    4. Inherited
        @Inherited 元注解用于指定注解是否被子类继承。如果一个注解被 @Inherited 标记了，那么这个注解将会被该类的子类所继承。
 */
public class MetaAnnotation {

}
