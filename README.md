# kotlinStudy

## Hello World
```
#编译成App
kotlinc hello.kt -include-runtime -d hello.jar
java -jar hello.jar

#编译成库
kotlinc hello.kt                  -d hello.jar
kotlin -classpath hello.jar HelloKt

#交互式解释器
kotlinc-jvm
:quit

#执行脚本
kotlinc -script helloScript.kts ..
```