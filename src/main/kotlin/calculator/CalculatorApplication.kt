package calculator

import calculator.const.InputOutputConst
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print(InputOutputConst.INPUT_MESSAGE)
    val input = sc.nextLine()

    val result = Calculator.calculate(input)
    println("${InputOutputConst.OUTPUT_MESSAGE}$result")
}
