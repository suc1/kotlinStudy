/*
有无companion的区别？？？？

伴生对象的成员看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员

实现创建一个对某个类做了轻微改动的类的对象，且不需要去声明一个新的子类

对象表达式和对象声明之间的差异如下:
1. 对象表达式用于创建一个匿名对象，而对象声明用于创建一个单例对象。
2. 对象表达式在使用时立即执行，而对象声明在首次访问时才被初始化。
3. 对象表达式可以实现接口或继承父类，而对象声明不能。
4. 对象表达式可以作为函数的参数或返回值传递，而对象声明不行
*/
class Product {
    var name = "shoe"
    companion object Factory{
        fun create() : Product {        //可以访问到外部类
            //println("${name}")          //error: unresolved reference: name
            return Product()
        }
    }
}

fun main(args: Array<String>) {
    val product = Product()
    println("product = ${product.name}")

    //val product2 = product.Factory.create()     //error: nested companion object 'Factory' accessed via instance reference
    val product2 = Product.Factory.create()
    //val product2 = Product.companion.create()
    println("product2 = ${product2.name}")
}