package study.step2

class Calculator() {

    fun calculate(input: String): Double {
        validateInput(input)

        val elements = input.split(" ")
        var result = validateNumber(elements[0])

        for (i in 1 until elements.size step 2) {
            val operation = Operator.fromSymbol(elements[i])
            val operand = validateNumber(elements[i + 1])

            result = operation.operation(result, operand)
        }
        return result
    }

    private fun validateInput(input: String) {
        require(input.isNotBlank()) { "입력값이 비어있습니다." }
    }

    private fun validateNumber(input: String): Double {
        return input.toDoubleOrNull() ?: throw IllegalArgumentException("올바르지 않는 입력값입니다.")
    }

    enum class Operator(val symbol: String, val operation: (Double, Double) -> Double) {
        ADD("+", { a, b -> a + b }),
        SUBTRACT("-", { a, b -> a - b }),
        MULTIPLY("*", { a, b -> a * b }),
        DIVIDE("/", { a, b -> if (b != 0.0) a / b else throw IllegalArgumentException("0으로 나눌 수 없습니다.") });

        companion object {
            fun fromSymbol(symbol: String): Operator {
                return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("연산자는 +, -, *, / 중 하나여야 합니다.")
            }
        }
    }
}
