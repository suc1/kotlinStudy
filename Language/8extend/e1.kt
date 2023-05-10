////进行扩展，且不需要继承或使用 Decorator 模式。
//扩展是一种静态行为
class User(var name:String) {

}

/**扩展函数**/
fun User.Print(){
    print("用户名 $name")
}

fun main1(){
    var user = User("Runoob")
    user.Print()
}

////// 扩展函数 swap,调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]                                  //this关键字指代接收者对象(receiver object)
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main2() {

    val l = mutableListOf(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值

    println(l.toString())
}

/////////////扩展函数是静态解析的，并不是接收者类型的虚拟成员
open class C {

}

class D: C() {

}

fun C.foo() = "c"   // 扩展函数 foo

fun D.foo() = "d"   // 扩展函数 foo

fun printFoo(c: C) {
    println( c.foo() )  // 类型是 C 类
}

fun main3(){
    printFoo( D() )     //c
}
