class Box<T>(t : T) {
    var value = t
}

fun main1() {
    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Runoob")

    println(boxInt.value)
    println(boxString.value)
}


///////// 泛型函数      类型参数要放在函数名的前面
fun main2() {
    fun <T> boxIn(value: T) = Box(value)

    // 以下都是合法语句
    val box4 = boxIn<Int>(1)
    println(box4.value)
    
    val box5 = boxIn(2)     // 编译器会进行类型推断
    println(box5.value)
}

////省略泛型参数
fun main() {

    fun <T> doPrintln(content: T) {
        when (content) {
            is Int -> println("整型数字为 $content")
            is String -> println("字符串转换为大写：${content.uppercase()}")
            else -> println("T 不是整型，也不是字符串")
        }
    }

    val age = 23
    doPrintln(age)    // 整型

    val name = "runoob"
    doPrintln(name)   // 字符串

    val bool = true
    doPrintln(bool)   // 布尔型
}
