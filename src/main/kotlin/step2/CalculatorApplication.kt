package step2

import step2.tasks.Calculator
import step2.util.Const.Companion.NOTICE_INPUT

fun main() {
    println(NOTICE_INPUT)
    with(Calculator()) {
        val anyOfCollection = splitReadLine()
        println(calculate(anyOfCollection))
    }
}
