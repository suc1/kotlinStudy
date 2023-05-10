fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

public fun sum3(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型

//Unit = void
fun sum4(a: Int, b: Int): Unit { 
    println(a + b)
}

// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
public fun sum5(a: Int, b: Int) { 
    println(a + b)
}

fun main() {
   println( sum(1,0) )
   println( sum2(1,1) )
   println( sum3(2,1) )
   sum4(2,2)
   sum4(2,3)
}