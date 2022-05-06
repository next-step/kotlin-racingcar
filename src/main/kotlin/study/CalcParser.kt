package study

object CalcParser {
    private val NUMERIC_REGEX = "-?[0-9]+(\\.[0-9]+)?".toRegex()

    fun parse(expression: String): CalcMachine {
        this.validate(expression)
        return this.createCalculateMachine(expression)
    }

    private fun createCalculateMachine(expression: String): CalcMachine {
        val expressionContext = expression.split(" ").groupBy(::isNumeric)
        val operators = expressionContext[false]!!.map(::convertToOperator)
        val numbers = expressionContext[true]!!.map(Operand::of)
        return CalcMachine(operators, numbers)
    }

    private fun convertToOperator(element: String): Operator =
        when (element) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "*" -> Operator.TIMES
            "/" -> Operator.DIV
            else -> throw IllegalArgumentException("지원하지 않는 연산자가 포함된 식입니다.")
        }

    private fun isNumeric(toCheck: String): Boolean = toCheck.matches(NUMERIC_REGEX)

    private fun validate(expression: String) {
        if (expression.isBlank() || expression.isEmpty()) {
            throw IllegalArgumentException("식이 빈 공백입니다.")
        }
    }
}
