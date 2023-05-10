fun main1(args: Array<String>) {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    for ((index, value) in items.withIndex()) {
        println("item at $index is $value")
    }
}

fun main2(args: Array<String>) {
    println("----while 使用-----")
    var x = 5
    while (x > 0) {
        println( x--)
    }

    println("----do...while 使用-----")
    var y = 5
    do {
        println(y--)
    } while(y>0)
}

fun main3(args: Array<String>) {
    for (i in 1..10) {
        if (i==3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        
        println(i)
        if (i>5) break   // i 为 6 时 跳出循环
    }
}

fun main() {
    loop@ for (i in 1..4) {     //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点
        println("i=$i")

        for (j in 1..3) {
            println("j=$j")
            if (j==2) break@loop
        }
    }
}
