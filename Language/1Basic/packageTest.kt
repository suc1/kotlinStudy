package com.runoob.main

import java.util.*

fun test() {
    println("test")
}

class Runoob {
    init{
        println("Runoob")
    }
}

fun main(args: Array<String>) {
   test()
   Runoob()

   //kotlin源文件不需要相匹配的目录和包
   com.runoob.main.test()
}