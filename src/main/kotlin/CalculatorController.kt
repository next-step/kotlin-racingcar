class CalculatorController(private val calculator: Calculator) {

    companion object {
        const val PLUS = '+'
        const val MINUS = '-'
        const val MULTIPLY = '*'
        const val DIVIDE = '/'
    }

    private fun selectExpression(exp: Char): (Int, Int) -> Int = when (exp) {
        PLUS -> calculator::add
        MINUS -> calculator::minus
        MULTIPLY -> calculator::multiply
        DIVIDE -> calculator::divide
        else -> throw IllegalArgumentException("$PLUS, $MINUS,$MULTIPLY, $DIVIDE 연산자를 사용하세요")
    }

    private fun calcTwoNums(num1: Int, expression: Char, num2: Int): Int {
        val applyExpression = selectExpression(expression)
        return applyExpression(num1, num2)
    }

    private data class ParsedExpression(
        val numbers: List<Int>,
        val operators: List<Char>
    )

    private fun parseInput(input: String): ParsedExpression {
        val numbers = input.split(Regex("[+\\-*/]"))
            .map { it.trim().toInt() }
        val operators = Regex("[+\\-*/]")
            .findAll(input)
            .map { it.value[0] }
            .toList()
        return ParsedExpression(numbers, operators)
    }

    fun calc(input: String): Int {
        val (numbers, operators) = parseInput(input)

        var result = numbers[0]
        for (i in operators.indices) {
            result = calcTwoNums(result, operators[i], numbers[i + 1])
        }
        return result
    }
}
