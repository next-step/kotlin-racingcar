package calculator

enum class Operator : MathElement {
    Addition {
        override val symbol = "+"
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value + operand2.value)
    },
    Subtraction {
        override val symbol = "-"
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value - operand2.value)
    },
    Multiplication {
        override val symbol = "*"
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value * operand2.value)
    },
    Division {
        override val symbol = "/"
        override fun calculate(operand1: Operand, operand2: Operand) =
            Operand(operand1.value / operand2.value)
    };

    abstract val symbol: String

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
