/*
伴生对象: 与外部类关联在一起
可以省略掉该对象的对象名
一个类里面只能声明一个内部关联对象
请伴生对象的成员看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员
*/
class Site {
    var name = "菜鸟教程"
    companion object DeskTop{
        var url = "www.runoob.com"
        fun showName(){
            print{"desk legs $name"} // 错误，不能访问到外部类的方法和变量
        }
    }
}
fun main(args: Array<String>) {
    var site = Site()
    site.DeskTop.url // 错误，不能通过外部类的实例访问到该对象
    Site.DeskTop.url // 正确
}
