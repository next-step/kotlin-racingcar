package calculator

fun execute(input: String?): Int {
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException("입력값을 제대로 기입해주세요.")
    }

    val inputChars = input.toCharArray()
        .filterNot { it.isWhitespace() }

    var result = 0
    var currentOperator: Char? = null

    for (inputChar in inputChars) {
        validateChar(inputChar)

        if (result == 0) {
            result = inputChar.toString().toInt()
            continue
        }

        if (isMathOperator(inputChar)) {
            currentOperator = inputChar
            continue
        }

        if (isCalculable(currentOperator, inputChar)) {
            result = calculate(currentOperator!!, result, inputChar.toString().toInt())
            currentOperator = null
        }
    }

    return result
}

private fun validateChar(inputChar: Char) {
    require(isMathOperator(inputChar) || inputChar.isDigit()) {
        "입력값은 숫자와 사칙연산('+', '-', '*', '/')만 기입해주세요."
    }
}

private fun isMathOperator(inputChar: Char): Boolean {
    return inputChar in setOf('+', '-', '*', '/')
}

private fun isCalculable(currentOperator: Char?, inputChar: Char): Boolean {
    return currentOperator != null && inputChar.isDigit()
}

private fun calculate(currentOperator: Char, result: Int, inputNum: Int): Int {
    return when (currentOperator) {
        '+' -> add(result, inputNum)
        '-' -> subtract(result, inputNum)
        '*' -> multiply(result, inputNum)
        '/' -> divide(result, inputNum)
        else -> result
    }
}
