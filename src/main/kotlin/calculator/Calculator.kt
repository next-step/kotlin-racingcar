package calculator

object Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("수식은 null 이거나 빈 공백 문자가 될 수 없습니다.")

        val listOfNumOrOperands = expression.split(" ")

        return parseNumber(listOfNumOrOperands)
    }

    private fun parseNumber(list: List<String>, operator: Operator = Operator.PLUS, result: Int = 0): Int = when (list.isEmpty()) {
        true -> throw IllegalArgumentException("Invalid expression")
        false -> parseOperand(list.drop(1), performOperation(operator, result, list[0].toInt()))
    }

    private fun parseOperand(list: List<String>, result: Int): Int = when (list.isEmpty()) {
        true -> result
        false -> parseNumber(list.drop(1), Operator.of(list[0]), result)
    }

    private fun performOperation(operator: Operator, first: Int, second: Int) = operator.calculate(first, second)

    private fun String.toInt(): Int = this.toIntOrNull() ?: throw IllegalArgumentException("Invalid number: $this")
}
