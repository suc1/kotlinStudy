////嵌套类
class Outer {                  // 外部类
    private val bar: Int = 1

    class Nested {             // 嵌套类
        fun foo() = 2
    }
}

fun main1() {
    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)    // == 2
}

////内部类
class Outer2 {
    private val bar: Int = 1
    var v = "成员属性"

    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer2 //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

fun main2() {
    val demo = Outer2().Inner().foo()
    println(demo) //   1

    val demo2 = Outer2().Inner().innerTest()    // 内部类可以引用外部类的成员，例如：成员属性
    println(demo2)                              //kotlin.Unit
}

////////匿名内部类
class Test {
    var v = "成员属性"

    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

/**
 * 定义接口
 */
interface TestInterFace {
    fun test()
}

fun main3() {
    var test = Test()

    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */
    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}

////类的修饰符
/*
abstract    // 抽象类  
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
*/

/*
private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
*/
