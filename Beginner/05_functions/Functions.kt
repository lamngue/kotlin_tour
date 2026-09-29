import kotlin.math.PI

fun circleArea(radius: Double): Double {
    return PI * radius * radius
}

fun circleAreaSingleExpression(radius: Double): Double =
    PI * radius * radius

fun intervalInSeconds(
    hours: Int = 0,
    minutes: Int = 0,
    seconds: Int = 0
) = ((hours * 60) + minutes) * 60 + seconds

fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) {
        action()
    }
}

fun demonstrateCircleArea() {
    println(circleArea(2.0))
    println(circleAreaSingleExpression(2.0))
}

fun demonstrateIntervals() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1, seconds = 25))
    println(intervalInSeconds(hours = 2))
    println(intervalInSeconds(minutes = 10))
    println(intervalInSeconds(hours = 1, seconds = 1))
}

fun demonstrateBookUrls() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5

    val urls = actions.map { action ->
        "$prefix/$id/$action"
    }

    println(urls)
}

fun demonstrateRepeatN() {
    repeatN(3) {
        println("Hello, Kotlin!")
    }
}

fun main() {
    demonstrateCircleArea()
    demonstrateIntervals()
    demonstrateBookUrls()
    demonstrateRepeatN()
}