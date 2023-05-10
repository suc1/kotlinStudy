/*
|| – 短路逻辑或
&& – 短路逻辑与
! - 逻辑非
*/

//数组
fun main1(args: Array<String>) {
    //[1,2,3]
    val a = arrayOf(1, 2, 3)        //Not var
    println(a)

    //[0,2,4]
    val b = Array(3, { i -> (i * 2) })      //工厂函数
    println(b)

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2

    //ByteArray, ShortArray, IntArray
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    println( x[0] )
}

//字符串
fun main2() {
    val text = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """
    println(text)    // 前置空格删除了

    val t2 = text.trimMargin()
    println(t2)
}

fun main3() {
    val str = "123"
    for (c in str) {
        println(c)
    }

    val text = """
    多行字符串
    多行字符串
    """
    println(text)   // 输出有一些前置空格
}

fun main(args: Array<String>) {
    val i = 10
    val s1 = "i = $i" // 求值结果为 "i = 10"
    println(s1)

    val s = "runoob"
    val str = "$s.length is ${s.length}" // 求值结果为 "runoob.length is 6"
    println(str)

    val price = """
    ${'$'}9.99
    """
    println(price)  // 求值结果为 $9.99     // $ 字符（它不支持反斜杠转义
}