fun main1() {
    //使用下划线使数字常量更易读
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
}

//没有基础数据类型，只有封装的对象，这样可以保证不会出现空指针
//三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
fun main2(args: Array<String>) {
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等
}

//显式转换  //box & unbox???
fun main3() {
    val b: Byte = 1         // OK, 字面值是静态检测的
    val i: Int = b.toInt()  // OK

    /*
    toByte(): Byte
    toShort(): Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double
    toChar(): Char
    */

    //根据上下文环境推断
    val l = 1L + 3 // Long + Int => Long

    //位操作符
    /*
    shl(bits) – 左移位 (Java’s <<)
    shr(bits) – 右移位 (Java’s >>)
    ushr(bits) – 无符号右移位 (Java’s >>>)
    and(bits) – 与
    or(bits) – 或
    xor(bits) – 异或
    inv() – 反向
    */
}

//----------------
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.code - '0'.code // 显式转换为数字
}

fun main() {
    println( decimalDigitValue('7') )
}