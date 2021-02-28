package calculator

import calculator.tasks.Calculator
import calculator.util.Const.Companion.NOTICE_INPUT

fun main() {
    println(NOTICE_INPUT)
    with(Calculator()) {
        val anyOfCollection = splitReadLine()
        println(calculate(anyOfCollection))
    }
}
