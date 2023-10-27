package calculator

enum class Operator(
    val symbol: String,
) {
    PLUS("+") {
        override fun operate(operand1: Double, operand2: Double): Double = operand1 + operand2
    },
    MINUS("-") {
        override fun operate(operand1: Double, operand2: Double): Double = operand1 - operand2
    },
    MULTIPLY("*") {
        override fun operate(operand1: Double, operand2: Double): Double = operand1 * operand2
    },
    DIVIDE("/") {
        override fun operate(operand1: Double, operand2: Double): Double {
            if (operand2 == 0.0) {
                throw ArithmeticException("Division by zero.")
            }
            return operand1 / operand2
        }
    },
    ;

    abstract fun operate(operand1: Double, operand2: Double): Double

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return Operator.values()
                .find { it.symbol == symbol }
                ?: throw NoSuchElementException("There is no Operator with symbol $symbol.")
        }

        fun getFourBasicOperators(): Set<Operator> {
            return setOf(PLUS, MINUS, MULTIPLY, DIVIDE)
        }

        fun isFourBasicOperations(symbol: String): Boolean {
            return symbol in getFourBasicOperators().map { it.symbol }
        }
    }
}
