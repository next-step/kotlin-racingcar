package calculator

import calculator.tasks.Calculator
import calculator.ui.splitReadLine

fun main() {
    with(Calculator()) {
        val anyOfCollection = splitReadLine()
        println(calculate(anyOfCollection))
    }
}
