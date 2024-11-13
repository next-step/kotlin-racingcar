class FourBasicOperations {
    private val nullInputErrorMessage: String = "입력값이 null이거나 빈 공백 문자입니다."
    private val badInputErrorMessage: String = "입력값이 잘못되었습니다."
    private val notSupportedOperatorErrorMessage: String = "사칙연산 기호가 아닙니다."

    fun calculate(expression: String): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException(nullInputErrorMessage)
        }

        val cleanedExpression = expression.replace(" ", "")
        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<Char>()
        var currentNumber = StringBuilder()

        parseExpression(cleanedExpression, numbers, operators, currentNumber)
        finalizeNumbers(numbers, operators, currentNumber)

        return evaluate(numbers, operators)
    }

    private fun parseExpression(
        expression: String,
        numbers: MutableList<Int>,
        operators: MutableList<Char>,
        currentNumber: StringBuilder,
    ) {
        val operatorList = listOf('+', '-', '*', '/')

        for (char in expression) {
            when {
                char.isDigit() -> currentNumber.append(char)
                char in operatorList -> {
                    if (currentNumber.isEmpty()) {
                        throw IllegalArgumentException(badInputErrorMessage)
                    }
                    numbers.add(currentNumber.toString().toInt())
                    currentNumber.clear()
                    operators.add(char)
                }
                else -> throw IllegalArgumentException(notSupportedOperatorErrorMessage)
            }
        }
    }

    private fun finalizeNumbers(
        numbers: MutableList<Int>,
        operators: MutableList<Char>,
        currentNumber: StringBuilder,
    ) {
        if (currentNumber.isNotEmpty()) {
            numbers.add(currentNumber.toString().toInt())
        } else if (operators.isNotEmpty()) {
            throw IllegalArgumentException(badInputErrorMessage)
        }
    }

    private fun evaluate(
        numbers: List<Int>,
        operators: List<Char>,
    ): Int {
        val values = numbers.toMutableList()
        val ops = operators.toMutableList()

        var i = 0
        while (i < ops.size) {
            if (ops[i] == '*' || ops[i] == '/') {
                val left = values[i]
                val right = values[i + 1]
                val result = if (ops[i] == '*') left * right else left / right
                values[i] = result
                values.removeAt(i + 1)
                ops.removeAt(i)
            } else {
                i++
            }
        }

        var total = values[0]
        for (j in 0 until ops.size) {
            total = if (ops[j] == '+') total + values[j + 1] else total - values[j + 1]
        }

        return total
    }
}
