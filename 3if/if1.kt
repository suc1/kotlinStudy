fun main1() {
    val a=1
    val b=3

    var max = a 
    if (a < b) {
        max = b
    }
    println(max)

    var max2: Int
    if (a > b) {
        max2 = a
    } else {
        max2 = b
    }
    println(max2)

    val max3 = if (a > b) a else b
    println(max3)
}

fun main2() {
    val a=1
    val b=3

    val max = if (a > b) {
        print("Choose a")
        a
        } else {
            print("Choose b")
            b
        }
    println(max)

    //需要像Java那种有一个三元操作符
    val max2 = if (a>b) a else b
    println(max2)
}

fun main3() {
    var x = 0
    if(x>0){
        println("x 大于 0")
    }else if(x==0){
        println("x 等于 0")
    }else{
        println("x 小于 0")
    }

    var a = 1
    var b = 2
    val c = if (a>=b) a else b
    println("c 的值为 $c")
}

fun main4() {
    val x = 11
    when (x) {                  
        //!in -10..0 -> print("x is in [-10, 0]")   //Find true then exit

        1 -> print("x == 1")
        2 -> print("x == 2")
        3, 4 -> print("x == 3, 4")      //很多分支需要用相同的方式处理

        in 10..20 -> print("x is in [10, 20]")
        

        else -> {                       //else 同 switch 的 default
            print("none of the above")
        }
    }
}

//when 也可以用来取代 if-else if链
fun main5() {
    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    println( hasPrefix("prefix") )


    var x = 0
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }

    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // 注意这个块
            println("x 不是 1 ，也不是 2")
        }
    }

    when (x) {
        in 0..10 -> println("x 在该区间范围内")
        else -> println("x 不在该区间范围内")
    }
}

fun main(args: Array<String>) {
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}