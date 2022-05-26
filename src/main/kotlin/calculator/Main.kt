package calculator

import java.util.Scanner

fun main() {
    val equationValidator = EquationValidator()
    val equationTokenizer = EquationTokenizer()
    val stringCalculator = StringCalculator()

    val input = InputView().input()
    equationValidator.validateEquation(input)

    val (operands, operators) = equationTokenizer.tokenize(input)
    val result = stringCalculator.calculate(operands, operators)

    OutputView().output(result)
}

class InputView(private val scanner: Scanner = Scanner(System.`in`)) {
    fun input(): String {
        print("식을 입력해주세요: ")
        return scanner.nextLine()
    }
}

class OutputView() {
    fun output(result: Double) {
        println("결과: $result")
    }
}
