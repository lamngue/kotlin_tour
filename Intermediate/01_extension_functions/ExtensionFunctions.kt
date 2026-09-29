fun Int.isPositive(): Boolean {
    return this > 0
}

fun String.toLowercaseString(): String {
    return this.lowercase()
}

fun main() {
    println(1.isPositive())
    // true
    
    println("Hello World!".toLowercaseString())
}