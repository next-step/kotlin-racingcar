package calculator

import calculator.const.InputOutputConst

fun main() {
    print(InputOutputConst.INPUT_MESSAGE)
    val input = readLine()

    val result = Calculator.calculate(input)
    println("${InputOutputConst.OUTPUT_MESSAGE}$result")
}
