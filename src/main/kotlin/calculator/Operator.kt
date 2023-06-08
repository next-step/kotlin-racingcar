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

        fun from(operatorString: String) = when (operatorString) {
            Addition.symbol -> Addition
            Subtraction.symbol -> Subtraction
            Multiplication.symbol -> Multiplication
            Division.symbol -> Division
            else -> throw IllegalArgumentException()
        }

        private fun symbols() = values().map {
            it.symbol
        }
    }
}
