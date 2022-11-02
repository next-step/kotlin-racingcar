package calculator.domain

data class Operator(private val value: String) {

    init {
        validate(value)
    }

    private fun validate(value: String) {
        if (PLUS != value
            && MINUS != value
            && MULTIPLY != value
            && DIVIDE != value
        ) {
            throw IllegalArgumentException()
        }
    }

    fun operate(operand1: Operand, operand2: Operand): Operand {
        if (PLUS == value) {
            return operand1.sum(operand2)
        }
        if (MINUS == value) {
            return operand1.subtract(operand2)
        }
        if (MULTIPLY == value) {
            return operand1.multiply(operand2)
        }
        if (DIVIDE == value) {
            return operand1.divide(operand2)
        }
        throw IllegalStateException()
    }

    companion object {
        private const val PLUS = "+"
        private const val MINUS = "-"
        private const val MULTIPLY = "*"
        private const val DIVIDE = "/"
    }
}
