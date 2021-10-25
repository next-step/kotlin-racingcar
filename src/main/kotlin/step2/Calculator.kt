package step2

const val BLANK = " "
const val INIT_NUMBER = 0
const val PLUS_NUMBER = 1

class Calculator {

    private val numbers = mutableListOf<Int>()
    private val operators = mutableListOf<String>()

    private var result: Int = INIT_NUMBER
    private lateinit var expression: String

    fun calculate(expression: String): Int {
        this.expression = expression
        classify()
        progress()
        return result
    }

    private fun classify() {
        expression.split(BLANK).forEach {
            when (it.toIntOrNull() != null) {
                true -> numbers.add(it.toInt())
                false -> operators.add(it)
            }
        }
    }

    private fun progress() {
        result = numbers[INIT_NUMBER]
        operators.forEachIndexed { index, operator ->
            compute(operator, numbers[index + PLUS_NUMBER])
        }
    }

    private fun compute(operator: String, number: Int) {
        result = Operator.getOperator(operator).operator.invoke(result, number)
    }
}
