package calculator

class Calculator {

    private val numbers = mutableListOf<Int>()
    private val operators = mutableListOf<String>()

    private var result: Int = NUMBER_ZERO
    private lateinit var expression: String

    fun calculate(input: String?): Int {
        verifyExpression(input)
        classify()
        calculatorByOperator()
        return result
    }

    private fun verifyExpression(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("널이거나 빈공백문자입니다.")
        }
        this.expression = input
    }

    private fun classify() {
        expression
            .split(BLANK)
            .forEach {
            when (it.toIntOrNull() != null) {
                true -> numbers.add(it.toInt())
                false -> operators.add(it)
            }
        }
    }

    private fun calculatorByOperator() {
        result = numbers[NUMBER_ZERO]
        operators
            .forEachIndexed { index, operator ->
            compute(operator, numbers[index + PLUS_NUMBER])
        }
    }

    private fun compute(operator: String, number: Int) {
        result = Operator.getOperator(operator).operator.invoke(result, number)
    }

    companion object {
        const val BLANK = " "
        const val NUMBER_ZERO = 0
        const val PLUS_NUMBER = 1
    }
}
