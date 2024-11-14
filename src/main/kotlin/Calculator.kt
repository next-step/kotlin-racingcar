class Calculator {
    fun calculate(expression: String): Double {
        val (operands, operators) = parseExpression(expression)

        var result = operands.first().value
        operators.forEachIndexed { index, operator ->
            result = operator.operate(result, operands[index + 1].value)
        }
        return result
    }

    private fun parseExpression(expression: String): MathExpression {
        val splitExpression = expression.split(" ")

        val operands = splitExpression
            .filterIndexed { index, _ -> index % 2 == 0 }
            .map { Operand(it) }
        val operators = splitExpression
            .filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.parse(it) }

        return MathExpression(operands, operators)
    }
}

data class MathExpression(
    val operands: List<Operand>,
    val operators: List<Operator>,
) {
    init {
        require(operands.size - operators.size == 1) { "피연산자와 연산자의 개수가 맞지 않습니다." }
    }
}

class Operand(
    value: String?,
) {
    val value: Double = value?.toDouble() ?: throw IllegalArgumentException("사칙 연산이 불가능한 값입니다.")
}

enum class Operator(
    private val value: String,
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
        fun parse(value: String): Operator {
            return entries.find { it.value == value } ?: throw IllegalArgumentException("지원하는 연산자가 아닙니다.")
        }
    }

    abstract fun operate(left: Double, right: Double): Double
}