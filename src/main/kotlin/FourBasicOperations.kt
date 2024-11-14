fun main() {
    val operations = FourBasicOperations()
    val input = readLine() ?: ""
    try {
        val result = operations.calculate(input)
        println("Result: $result")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

class FourBasicOperations {
    private val nullInputErrorMessage: String = "입력값이 null이거나 빈 공백 문자입니다."
    private val badInputErrorMessage: String = "입력값이 잘못되었습니다."
    private val notSupportedOperatorErrorMessage: String = "사칙연산 기호가 아닙니다."

    fun calculate(expression: String): Int {
        if (expression.isBlank()) {
            throw IllegalArgumentException(nullInputErrorMessage)
        }

        val cleanedExpression = expression.replace(" ", "")
        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<Operator>()
        val currentNumber = StringBuilder()

        parseExpression(cleanedExpression, numbers, operators, currentNumber)
        finalizeNumbers(numbers, operators, currentNumber)

        return evaluate(numbers, operators)
    }

    private fun parseExpression(
        expression: String,
        numbers: MutableList<Int>,
        operators: MutableList<Operator>,
        currentNumber: StringBuilder,
    ) {
        for (char in expression) {
            when {
                char.isDigit() -> currentNumber.append(char)
                else -> {
                    if (currentNumber.isEmpty()) {
                        throw IllegalArgumentException(badInputErrorMessage)
                    }
                    numbers.add(currentNumber.toString().toInt())
                    currentNumber.clear()
                    try {
                        operators.add(Operator.from(char.toString()))
                    } catch (e: IllegalArgumentException) {
                        throw IllegalArgumentException(notSupportedOperatorErrorMessage)
                    }
                }
            }
        }
    }

    private fun finalizeNumbers(
        numbers: MutableList<Int>,
        operators: MutableList<Operator>,
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
        operators: List<Operator>,
    ): Int {
        val values = numbers.toMutableList()
        val ops = operators.toMutableList()

        var i = 0
        while (i < ops.size) {
            if (ops[i] == Operator.MULTIPLY || ops[i] == Operator.DIVIDE) {
                val left = values[i]
                val right = values[i + 1]
                val result = if (ops[i] == Operator.MULTIPLY) left * right else left / right
                values[i] = result
                values.removeAt(i + 1)
                ops.removeAt(i)
            } else {
                i++
            }
        }

        var total = values[0]
        for (j in 0 until ops.size) {
            total = if (ops[j] == Operator.SUM) total + values[j + 1] else total - values[j + 1]
        }

        return total
    }
}
