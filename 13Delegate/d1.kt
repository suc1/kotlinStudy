import kotlin.reflect.KProperty

/////////////// 类委托
// 创建接口
interface Base {   
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

// 通过关键字 by 建立委托类 : 避免写函数去调用执行类!!
class Derived(b: Base) : Base by b      //将 b 保存在 Derived 的对象实例内部，并将调用转发给 b

fun main1() {
    val b = BaseImpl(10)
    Derived(b).print() // 输出 10
}

////////////// 属性委托

// 定义包含属性委托的类
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

fun main2() {
    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数

    e.p = "Runoob"   // 调用 setValue() 函数
    println(e.p)
}

//////////标准委托
//延迟属性 Lazy
fun main() {
    val lazyValue: String by lazy {
        println("computed!")     // 第一次调用输出，第二次调用不执行    //????????
        "Hello"
    }

    println(lazyValue)   // 第一次执行，执行两次输出表达式      //computed!     //Hello
    println(lazyValue)   // 第二次执行，只输出返回值            //Hello
}
