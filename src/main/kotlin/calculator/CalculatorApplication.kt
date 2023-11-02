package calculator

import calculator.controller.CalculatorController
import calculator.view.InputView.Companion.inputString
import calculator.view.PrintView.Companion.printResult

fun main() {
    val input = inputString()
    val words = input.split(" ")
    val result = CalculatorController(words).getResult()
    printResult(result)
}
