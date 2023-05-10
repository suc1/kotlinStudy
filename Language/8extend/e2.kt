
////若扩展函数和成员函数一致，会优先使用成员函数。      //扩展没意义
class C {
    fun foo() { println("成员函数") }
}

fun C.foo() { println("扩展函数") }     // warning: extension is shadowed by a member

fun main1(){
    var c = C()
    c.foo()
}

////扩展一个空对象
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

fun main2(){
    var t = null
    println(t.toString())
}

////扩展属性        不允许定义在函数中      只能被声明为 val
// 定义一个扩展属性
val String.lastChar: Char
    get() = this[length - 1]

// 使用扩展属性
fun main3() {
    val str = "Hello"
    println(str.lastChar)  // 输出 'o'
}

////伴生对象的扩展
class MyClass {
    companion object { }  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

fun main() {
    println("no:${MyClass.no}")
    MyClass.foo()
}
