package calculator

import calculator.view.InputViewImpl

fun main() {
    val calculator = Calculator(InputViewImpl(readlnOrNull = { readlnOrNull() }))

    val result = calculator.calculate()

    println("result = $result")
}
