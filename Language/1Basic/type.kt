fun getStringLength(obj: Any): Int? {
  if (obj is String) {
    // 做过类型判断以后，obj会被系统自动转换为String类型
    return obj.length 
  }

  //在这里还有一种方法，与Java中instanceof不同，使用!is
  // if (obj !is String){
  //   // XXX
  // }

  // 这里的obj仍然是Any类型的引用
  return null
}

fun getStringLength2(obj: Any): Int? {
  if (obj !is String)
    return null

  // 在这个分支中, `obj` 的类型会被自动转换为 `String`
  return obj.length
}

fun getStringLength3(obj: Any): Int? {
  // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
  if (obj is String && obj.length > 0)
    return obj.length
  return null
}

fun main(args: Array<String>) {
   println( getStringLength("123") )
   println( getStringLength2("123") )
   println( getStringLength3("123") )
}