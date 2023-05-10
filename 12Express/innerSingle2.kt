class Product {
    var name = "shoe"
    object Factory{
        fun create() : Product{
            //return Product //classifier 'Product' does not have a companion object, and thus must be initialized here
            return Product()
        }
    }
}

fun main(args: Array<String>) {
    val product = Product()
    println("product = ${product.name}")

    //val product2 = product.Factory.create()     //error: nested object 'Factory' accessed via instance reference
    val product2 = Product.Factory.create()
    println("product2 = ${product2.name}")
}