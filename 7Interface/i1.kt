////Kotlin 接口, 允许方法有默认实现

interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}

class Child : MyInterface {
    override fun bar() {
        // 方法体
        println("bar")
    }

    override fun foo() {
        println("child.foo")
        super.foo()
    }
}

fun main1() {
    val c =  Child()
    
    c.foo();
    c.bar(); 
}

///////接口中的属性, 只能是抽象的. 实现接口时，必须重写属性
interface MyInterface2 {
    var name:String //name 属性, 抽象的
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child2 : MyInterface2 {
    override var name: String = "runoob" //重写属性
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun main2() {
    val c =  Child2()
    c.foo();
    c.bar();
    println(c.name) 
}

////////////函数重写        同一方法继承多个Interface
interface A {
    fun foo() { print("A") }   // 已实现
    fun bar()                  // 未实现，没有方法体，是抽象的
}
 
interface B {
    fun foo() { print("B") }   // 已实现
    fun bar() { print("bar") } // 已实现
}
 
class C : A {
    override fun bar() { print("bar") }   // 重写
}
 
class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
 
    override fun bar() {
        super<B>.bar()
    }
}
 
fun main() {
    val d =  D()
    d.foo();    //AB
    d.bar();    //bar

    val c = C()
    c.bar()
    c.foo()
}