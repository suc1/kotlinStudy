//对象表达式和对象声明来实现创建一个轻微改动的类的对象，且不需要去声明一个新的子类
fun main1() {
    val site = object {
        var name: String = "菜鸟教程"
        var url: String = "www.runoob.com"
    }

    println(site.name)
    println(site.url)
}


//匿名对象可以用作只在本地和私有作用域中声明的类型

//在对象表达中可以方便的访问到作用域中的其他变量

object Site {
    var url:String = ""
    val name: String = "菜鸟教程"
}
fun main2() {
    var s1 =  Site
    var s2 = Site

    s1.url = "www.runoob.com"
    println(s1.url)
    println(s2.url)
}

////对象声明: object
////当object声明在另一个类的内部时
class Site3 {
    var name = "菜鸟教程"
    object DeskTop{
        var url = "www.runoob.com"
        fun showName(){
            //print{"desk legs $name"} // 错误，不能访问到外部类的方法和变量
        }
    }
}
fun main() {
    var site = Site3()
    //site.DeskTop.url // 错误，不能通过外部类的实例访问到该对象
    Site.DeskTop.url // 正确
}

///////////伴生对象: 只能声明一个内部关联对象: 关键字 companion 只能使用一次
//看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员


/*对象表达式和对象声明之间的语义差异

对象表达式是在使用他们的地方立即执行的

对象声明是在第一次被访问到时延迟初始化的

伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
*/