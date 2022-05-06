package study

object CalcParser {
    private val NUMERIC_REGEX = "-?[0-9]+(\\.[0-9]+)?".toRegex()

    fun parse(expression: String): CalcMachine {
        this.validate(expression)
        return this.createCalculateMachine(expression)
    }

    private fun createCalculateMachine(expression: String): CalcMachine {
        val expressionContext = expression.split(" ").groupBy(::isNumeric)
        val operators = expressionContext[false]!!.map(Operator::of)
        val numbers = expressionContext[true]!!.map(Operand::of)
        return CalcMachine(operators, numbers)
    }

    private fun isNumeric(toCheck: String): Boolean = toCheck.matches(NUMERIC_REGEX)

    private fun validate(expression: String) {
        if (expression.isBlank() || expression.isEmpty()) {
            throw IllegalArgumentException("식이 빈 공백입니다.")
        }
    }
}
