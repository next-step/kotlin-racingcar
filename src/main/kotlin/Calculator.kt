class Calculator {
    fun calculate(expression: String): Double {
        val mathExpression = MathExpression(expression)
        val operands = mathExpression.operands
        val operators = mathExpression.operators
        return operators.foldIndexed(operands[0].value) { index, acc, operator ->
            operator.operate(acc, operands[index + 1].value)
        }
    }
}

private class MathExpression(
    expression: String,
) {
    val operands: List<Operand>
    val operators: List<Operator>

    init {
        val splitExpression = expression.split(" ")
        val operands = splitExpression
            .filterIndexed { index, _ -> index % 2 == 0 }
            .map { Operand(it) }
        val operators = splitExpression
            .filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.parse(it) }

        require(operands.size - operators.size == 1) { "피연산자와 연산자의 개수가 맞지 않습니다." }

        this.operands = operands
        this.operators = operators
    }
}

private class Operand(
    value: String?,
) {
    val value: Double = value?.toDouble() ?: throw IllegalArgumentException("사칙 연산이 불가능한 값입니다.")
}

private enum class Operator(
    private val symbol: String,
) {
    PLUS("+") {
        override fun operate(left: Double, right: Double) = left + right
    },
    MINUS("-") {
        override fun operate(left: Double, right: Double) = left - right
    },
    MULTIPLY("*") {
        override fun operate(left: Double, right: Double) = left * right
    },
    DIVIDE("/") {
        override fun operate(left: Double, right: Double) = left / right
    },
    ;

    companion object {
        fun parse(symbol: String): Operator {
            return entries.find { it.symbol == symbol } ?: throw IllegalArgumentException("지원하는 연산자가 아닙니다.")
        }
    }

    abstract fun operate(left: Double, right: Double): Double
}