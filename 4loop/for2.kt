fun main() {
    fun foo() {
        val ints = Array(5) { i -> i }

        ints.forEach {
            if (it == 3) return
            println(it)
        }
    }

    foo()
}