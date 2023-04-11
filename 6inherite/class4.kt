/////////属性重写
//你可以用一个var属性重写一个val属性，但是反过来不行

interface Foo {
    //val count: Int = 0        // error: property initializers are not allowed in interfaces
    val count: Int              // 接口可以是变量
}

//class Bar1() : Foo {      //class 'Bar1' is not abstract and does not implement abstract member public abstract val count: Int defined in Foo
class Bar1(override val count: Int) : Foo {
}

class Bar2 : Foo {
    override var count: Int = 0
}

fun main() {
    val b1 = Bar1(123)
    println( b1.count )
    //println( b1.super.count )

    val b2 = Bar2()
    println( b2.count )
    //println( b2.super.count )
}
