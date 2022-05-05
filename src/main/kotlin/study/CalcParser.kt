package study

object CalcParser {
    fun parse(expression: String): CalcMachine {
        this.validate(expression)

        val map = expression
            .split(" ")
            .groupBy(this::isNumeric)
        return this.generateCalcMachine(map)
    }

    private fun generateCalcMachine(map: Map<Boolean, List<String>>): CalcMachine  {
        val operators = map[false]!!.map(this::convertToOperator)
        val numbers = map[true]!!.map(this::convertToOperand)
        return CalcMachine(operators, numbers)
    }

    private fun convertToOperator(element: String): Operator =
        when(element) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "*" -> Operator.TIMES
            "/" -> Operator.DIV
            else -> throw IllegalArgumentException("지원하지 않는 연산자가 포함된 식입니다.")
        }

    private fun convertToOperand(element: String): Operand = Operand(element.toInt())

    private fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }

    private fun validate(expression: String) {
        if (expression.isBlank() || expression.isEmpty()) {
            throw IllegalArgumentException("식이 빈 공백입니다.")
        }
    }
}
