//class Person public constructor(firstName: String) {}     //如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略
//class DontCreateMe private constructor () {)              //声明一个空的主构造函数
//class Customer(val customerName: String = "")


class Person {
    var lastName: String = "zhang"
        get() = field.uppercase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量    //不能有字段
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

// 测试
fun main1() {
    var person: Person = Person()

    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")
}

//////2
class Runoob  constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    // error: 'val' on secondary constructor parameter is not allowed
    constructor(name: String, version: Int) : this(name) {       //代理主构造函数
        println("Version = $version")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun main2() {
    //val runoob =  Runoob("菜鸟教程")
    val runoob =  Runoob("菜鸟教程", 1)

    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}

//////3 抽象类, 无需对抽象类或抽象成员标注open注解
open class Base {
    open fun f() {
        println("Base")
    }
}

abstract class Derived : Base() {
    override abstract fun f()
}

class final : Derived() {
    override fun f() {
        println("final")
        //Base.f()          //???
    }
}

fun main() {
    val test = final()
    test.f()
}