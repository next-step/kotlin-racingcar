package step2

class InOrderCalculator {
    private val DELIMETER = " "

    fun calculate(expression: String?): Double {
        val expressions = expression?.split(DELIMETER)?.toMutableList() ?: throw IllegalArgumentException()

        var result: Double = expressions[0].toDouble()
        var operator: String? = null

        (1 until expressions.size).forEach { index ->
            if (index % 2 != 0) {
                //isOperator
                operator = expressions[index]
            } else {
                result = Operator.execute(result, expressions[index].toDouble(), operator)
            }
        }
        return result
    }
}
