/////泛型约束       默认的上界是 Any?
fun main1() {
    fun <T : Comparable<T> > sort(list: List<T>) {
        for(it in list) println(it)
    }

    sort( listOf(1, 2, 3) ) // OK。Int 是 Comparable<Int> 的子类型
    //sort(listOf(HashMap<Int, String>())) // 错误：HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型
}

////多个上界约束条件
fun main2() {
    fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
            T : Comparable<T> {
            return list.filter { it > threshold }.map { it.toString() }
    }

    //ToDo: test??
}

/////型变: 没有通配符类型，声明处型变（declaration-site variance）与类型投影（type projections）
// out 协变类型参数只能用作输出
// 定义一个支持协变的类
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

fun main3() {
    var strCo: Runoob<String> = Runoob("a")
    var anyCo: Runoob<Any> = Runoob<Any>("b")
    println(anyCo.foo())   // 输出 b

    anyCo = strCo
    println(anyCo.foo())   // 输出 a
}

// in 逆变类型参数只能用作输入
// 定义一个支持逆变的类         ???????????????????????????
class Runoob4<in A>(a: A) {
    fun foo(a: A) {
        println("Runoob4 = $a")
    }
}

fun main4() {
    var strDCo = Runoob4("a")
    println(strDCo.foo( "a" ))

    var anyDCo = Runoob4<Any>("b")
    strDCo = anyDCo
    println(strDCo.foo("b"))
}

////////////星号投射: 要求这个泛型类型的所有的实体实例, 都是这个投射的子类型
//?????????????????????
//*代指了所有类型，相当于Any?
class A<T>(val t: T, val t2 : T, val t3 : T)

class Apple(var name : String)

fun main() {
    //使用类    
    val a1: A<*> = A(12, "String", Apple("苹果"))
    val a2: A<Any?> = A(12, "String", Apple("苹果"))   //和a1是一样的
    
    val apple = a1.t3    //参数类型为Any
    println(apple)
    
    val apple2 = apple as Apple   //强转成Apple类
    println(apple2.name)
    
    //使用数组
    val l:ArrayList<*> = arrayListOf("String",1,1.2f,Apple("苹果"))
    for (item in l){
        println(item)
    }
}