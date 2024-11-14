package operation

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
        val numbers = parseNumbers(cleanedExpression)
        val operators = parseOperators(cleanedExpression)

        return evaluate(numbers, operators)
    }

    fun parseNumbers(expression: String): List<Int> {
        val numbers = mutableListOf<Int>()
        val currentNumber = StringBuilder()

        for (char in expression) {
            if (char.isDigit()) {
                currentNumber.append(char)
            } else if (char != ' ') {
                if (currentNumber.isNotEmpty()) {
                    numbers.add(currentNumber.toString().toInt())
                    currentNumber.clear()
                }
            }
        }

        if (currentNumber.isNotEmpty()) {
            numbers.add(currentNumber.toString().toInt())
        }

        return numbers
    }

    fun parseOperators(expression: String): List<Operator> {
        val operators = mutableListOf<Operator>()
        val currentNumber = StringBuilder()
        val operatorList = Operator.entries.map { it.symbol }
        var lastWasOperator = false

        for (char in expression) {
            if (char.isDigit()) {
                currentNumber.append(char)
                lastWasOperator = false
            } else if (char != ' ') {
                if (operatorList.contains(char.toString())) {
                    if (currentNumber.isEmpty() && operators.isEmpty()) {
                        throw IllegalArgumentException(badInputErrorMessage)
                    }

                    if (lastWasOperator) {
                        throw IllegalArgumentException(badInputErrorMessage)
                    }

                    operators.add(Operator.from(char.toString()))
                    lastWasOperator = true
                } else {
                    throw IllegalArgumentException(notSupportedOperatorErrorMessage)
                }
            }
        }

        return operators
    }

    fun evaluate(
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
