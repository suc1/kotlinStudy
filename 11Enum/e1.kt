enum class Color{
    RED,BLACK,BLUE,GREEN,WHITE
}
fun main1() {
    println(Color.values())             //[LColor;@27abe2cd
    println(Color.valueOf("RED"))       //RED

    var color:Color=Color.BLUE
    println(color.name)                 //BLUE
    println(color.ordinal)              //2
}

//每一个枚举都是枚举类的实例，它们可以被初始化
enum class Color2(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
fun main2() {
    println(Color2.values())             //[LColor2;@27abe2cd
    println(Color2.valueOf("RED"))       //RED

    var color:Color2=Color2.BLUE
    println(color.name)                 //BLUE
    println(color.ordinal)              //2
    println(color)                      //BLUE
    println(color.rgb)                  //255
}

enum class Shape(value:Int){
    ovel(100),
    rectangle(200)
}
fun main3() {
    println(Shape.ovel)
    //println(Shape.ovel.value)   //How to print the value in Shape without `val value:Int`
}


//声明自己的匿名类及相应的方法、以及覆盖基类的方法
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
fun main4() {
    //????????????????
}

//以泛型的方式访问枚举类中的常量
enum class RGB { RED, GREEN, BLUE }
inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

fun main() {
    printAllValues<RGB>() // 输出 RED, GREEN, BLUE
}