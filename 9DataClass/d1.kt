data class User(val name: String, val age: Int)

fun main1() {
    val jack = User(name = "Jack", age = 1)
    //fun copy(name: String = this.name, age: Int = this.age) = User(name, age)
    val olderJack = jack.copy(age = 2)

    println(jack)
    println(olderJack)
}

fun main2() {
    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // prints "Jane, 35 years of age"
}

//Pair 和 Triple

////密封类: 密封类用来表示受限的类继承结构, 是枚举类的扩展
//Object: 1.定义单例对象        2.伴生对象(companion object)(替代static)(@JvmStatic)            3.对象表达式

sealed class Expr       //modifier 'sealed' is not applicable to 'local class'

data class Const(val number: Double) : Expr()

data class Sum(val e1: Expr, val e2: Expr) : Expr()

object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}

fun main() {
    val v1 = Const(1.2)
    println( eval(v1) )

    val v2 = Const( 3.6 )
    val sum = Sum(v1, v2)
    println( eval(sum) )

    val v3 = NotANumber     //NotANumber() error: expression 'NotANumber' of type 'NotANumber' cannot be invoked as a function. The function 'invoke()' is not found
    println( eval(v3) )
}