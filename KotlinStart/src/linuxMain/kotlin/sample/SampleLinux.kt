package sample

fun hello(): String = "Hello, Kotlin/Native!"

fun add(a: Int, b: Int): Int {
    return a+b;
}

fun main() {
    println(hello())
    println(add(4,5))
}