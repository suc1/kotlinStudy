//以成员的形式定义的扩展函数, 可以声明为 open 
// 针对分发接受者是虚拟的(virtual), 但针对扩展接受者仍然是静态的

open class D {
}

class D1 : D() {
}

open class C {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()   // 调用扩展函数
    }
}

class C1 : C() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}


fun main1() {
    C().caller(D())   // 输出 "D.foo in C"
    C1().caller(D())  // 输出 "D.foo in C1" —— 分发接收者虚拟解析
    C().caller(D1())  // 输出 "D.foo in C" —— 扩展接收者静态解析

}

////伴生对象内的成员相当于 Java 中的静态成员
//类内扩展
//类外扩展
class MyClass {
    companion object {
        val myClassField1: Int = 1
        var myClassField2 = "this is myClassField2"
        fun companionFun1() {
            println("this is 1st companion function.")
            foo()
        }
        fun companionFun2() {
            println("this is 2st companion function.")
            companionFun1()
        }
    }
    fun MyClass.Companion.foo() {
        println("伴随对象的扩展函数（内部）")
    }
    fun test2() {
        MyClass.foo()
    }
    init {
        test2()
    }
}
val MyClass.Companion.no: Int
    get() = 10
fun MyClass.Companion.foo() {
    println("foo 伴随对象外部扩展函数")
}
fun main() {
    println("no:${MyClass.no}")
    println("field1:${MyClass.myClassField1}")
    println("field2:${MyClass.myClassField2}")
    MyClass.foo()
    MyClass.companionFun2()
}