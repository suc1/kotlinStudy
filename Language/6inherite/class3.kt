/*
Any 类

equals()
hashCode()
toString()
*/

//////子类有主构造函数
open class Person(var name : String, var age : Int){// 基类
}

class Student(name : String, age : Int, var no : String, var score : Int) : Person(name, age) {
    //no var before name 
}

fun main1() {
    val s =  Student("Runoob", 18, "S12346", 89)

    println("学生名： ${s.name}")
    println("年龄： ${s.age}")
    println("学生号： ${s.no}")
    println("成绩： ${s.score}")
}

//////子类没有主构造函数
/**用户基类**/
open class Person2(name:String){
    /**次级构造函数**/
    constructor(name:String,age:Int):this(name){
        //初始化
        println("-------基类次级构造函数---------")
    }
}

/**子类继承 Person 类**/
class Student2:Person2{

    /**次级构造函数**/
    constructor(name:String, age:Int, no:String, score:Int):super(name,age){
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

fun main2(args: Array<String>) {
    var s =  Student2("Runoob", 18, "S12345", 89)
    //println("学生名： ${s.name}")       // unresolved reference: name
    //println("学生号： ${s.no}")         //unresolved reference: no
}


///////////////重写     open    override
/**用户基类**/
open class Person3{
    open fun study(){       // 允许子类重写
        println("我毕业了")
    }
}

/**子类继承 Person 类**/
class Student3 : Person3() {

    override fun study(){    // 重写方法
        println("我在读大学")
    }
}

fun main3() {
    val s =  Student3()
    s.study();

}

//使用super范型去选择性地调用父类的实现
open class A {
    open fun f () { println("A") }
    fun a() { println("a") }
}

interface B {
    //var i = 0       //error: property initializers are not allowed in interfaces
    fun f() { println("B") } //接口的成员变量默认是 open 的
    fun b() { println("b") }
}

class C() : A() , B{
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

fun main() {
    val c =  C()
    c.f();

    c.a()
    c.b()
}