
fun main1() {
    //类型后面加?表示可为空
    var age: String? = "23" 
    //var age: String? = null
    println(age)

    //抛出空指针异常
    val ages = age!!.toInt()
    println(ages)
    
    //不做处理返回 null
    val ages1 = age?.toInt()
    println(ages1)

    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
    println(ages2)
}

//-----------------------------
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致错误, 因为它们可能为 null
    if (x != null && y != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }    
}

fun main2() {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")
}

//----------------------------
fun parseInt3(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct3(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    
    // ...
    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
    println(x * y)
}

fun main() {
    printProduct3("6", "7")
    printProduct3("a", "7")
    printProduct3("99", "b")
}
