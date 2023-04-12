////扩展的作用域
//????

//扩展声明为成员
class D {
    fun bar() { println("D bar") }
}

class C {
    fun baz() { println("C baz") }

    fun D.foo() {
        bar()   // 调用 D.bar           //D: 扩展接受者, 优先
        baz()   // 调用 C.baz           //C: 分发接受者, this
    }

    fun caller(d: D) {
        d.foo()   // 调用扩展函数
    }
}

fun main1() {
    val c: C = C()
    val d: D = D()
    
    c.caller(d)
}

/////
class D2 {
    fun bar() { println("D bar") }
}

class C2 {
    fun bar() { println("C bar") }  // 与 D2 类 的 bar 同名

    fun D2.foo() {
        bar()         // 调用 D2.bar()，扩展接收者优先
        this@C2.bar()  // 调用 C.bar()
    }

    fun caller(d: D2) {
        d.foo()   // 调用扩展函数
    }
}

fun main() {
    val c: C2 = C2()
    val d: D2 = D2()
    
    c.caller(d)
}
