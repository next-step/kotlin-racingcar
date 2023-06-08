package calculator

enum class Operator(private val symbol: String) : MathElement {
    Addition("+") {
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value + operand2.value)
    },
    Subtraction("-") {
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value - operand2.value)
    },
    Multiplication("*") {
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value * operand2.value)
    },
    Division("/") {
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value / operand2.value)
    };

    abstract fun calculate(operand1: Operand, operand2: Operand): Operand

    companion object {
        fun isOperatorSymbol(operatorString: String): Boolean {
            return operatorString in symbols()
        }

        fun from(operatorString: String) = values().find {
            it.symbol == operatorString
        }
            ?: throw IllegalArgumentException("Unsupported operator: $operatorString. Please input a valid operator (+, -, *, /).")

        private fun symbols() = values().map {
            it.symbol
        }
    }
}
