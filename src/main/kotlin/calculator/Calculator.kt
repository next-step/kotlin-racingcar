package calculator

class Calculator {

    fun calculate(expression: String): Double {
        validCheck(expression)
        val expressions = expression.splitByBlank()
        var result = expressions[0].toDouble()
        for (index in 1 until expressions.size step 2) {
            result = Operator.find(expressions[index])
                .number(result, expressions[index + 1].toDouble())
        }
        return result
    }

    private fun String.splitByBlank() = this.split(" ")

    private fun validCheck(expression: String?) {
        requireNotNull(expression) {
            "Empty Expression"
        }
    }
}
