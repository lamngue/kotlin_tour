fun fetchData(callback: StringBuilder.() -> Unit) {
    val builder = StringBuilder("Data received")
    builder.callback()
}

data class ButtonEvent(
    val isRightClick: Boolean,
    val amount: Int,
    val position: Position
)

data class Position(
    val x: Int,
    val y: Int
)

class Button {
    fun onEvent(action: ButtonEvent.() -> Unit) {
        val event = ButtonEvent(
            isRightClick = false,
            amount = 2,
            position = Position(100, 200)
        )

        event.action()
    }
}

fun List<Int>.incremented(): List<Int> {
    return buildList {
        for (item in this@incremented) {
            add(item + 1)
        }
    }
}

fun demonstrateFetchData() {
    fetchData {
        append(" - Processed")
        println(this)
    }
}

fun demonstrateButtonEvent() {
    val button = Button()

    button.onEvent {
        if (!isRightClick && amount == 2) {
            println(
                "Double click detected at position: (${position.x}, ${position.y})"
            )
        }
    }
}

fun demonstrateExtensionFunction() {
    val originalList = listOf(1, 2, 3)
    val newList = originalList.incremented()

    println(newList)
}

fun main() {
    demonstrateFetchData()
    demonstrateButtonEvent()
    demonstrateExtensionFunction()
}