package calculator

class Calculator {

    private var inputStrings = mutableListOf<String>()

    fun append(inputString: String) {
        inputStrings.add(inputString)
    }

    fun clear() {
        inputStrings.clear()
    }

    fun result(): Int {
        val joinedString = inputStrings.joinToString(" ")

        val expression = Expression(joinedString.split(" "))
        return calculate(expression.digits.first().toInt(), expression.operators, expression.digits.drop(1))
    }

    private fun calculate(value: Int, operators: List<String>, digits: List<String>): Int {
        return if (digits.isEmpty()) {
            value
        } else {
            val digit = digits.first().toInt()
            val operator = operators.first()

            val appliedValue = Operator.of(operator).apply(value, digit)
            calculate(appliedValue, operators.drop(1), digits.drop(1))
        }
    }
}
