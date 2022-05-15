package expressioncalculator

import expressioncalculator.calculator.Calculator

private const val INVALID_INPUT_ERROR_MESSAGE = "\n적합하지 않은 입력값이 전달되었습니다.\n입력값은 공백으로만 이루어져서는 안 됩니다."

fun main() {
    val expression = readlnOrNull()
    require(!expression.isNullOrBlank()) {
        INVALID_INPUT_ERROR_MESSAGE
    }

    val calculator = Calculator()
    println(calculator.calculate(expression))
}
