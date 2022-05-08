package step2

class StringCalculator {

    private val exprQueue = mutableListOf<String>()

    fun append(expression: String): StringCalculator {
        require(expression.isNotEmpty()) {
            "expression cannot be empty"
        }

        val processedExpr = expression.replace(" ", "")
        exprQueue.add(processedExpr)

        return this
    }

    fun result(): Double {
        val parser = Expression(display())
        val operands = parser.operands
        val operators = parser.operators

        require(operands.size == operators.size) {
            "피연산자의 수(${operands.size})와 연산자 수(${operators.size - 1})가 적합하지 않습니다 " +
                "ex. 피연산자 수 == 연산자 수 + 1"
        }

        return calculate(0.0, operators, operands)
    }

    fun display(): String = exprQueue.joinToString("")

    fun clear() = exprQueue.clear()

    private fun calculate(accum: Double, operators: List<Operator>, operands: List<Double>): Double =
        if (operands.isEmpty()) {
            accum
        } else {
            calculate(
                operators.first()
                    .apply(
                        accum,
                        operands.first()
                    ),
                operators.drop(1),
                operands.drop(1)
            )
        }
}
