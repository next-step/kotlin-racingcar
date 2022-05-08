package calculator

class Calculator {
    fun input(expression: String?): Int {
        checkExpressionNullOrEmpty(expression)
        expression ?: return -1

        val expressionContents: List<String> = expression.split(" ")

        var result = 0
        var operation: String? = null

        expressionContents.forEachIndexed { index, content ->
            checkOperation(content)

            if (index == 0) {
                result = content.toInt()
                return@forEachIndexed
            }

            if (isOperation(content)) {
                operation = content
                return@forEachIndexed
            }

            result = calculate(first = result, second = content.toInt(), operation = operation)
        }

        return result
    }

    private fun calculate(first: Int, second: Int, operation: String?): Int {
        return when (operation) {
            "+" -> plus(first, second)
            "-" -> minus(first, second)
            "*" -> multiply(first, second)
            "/" -> division(first, second)
            else -> first
        }
    }

    private fun checkExpressionNullOrEmpty(expression: String?) {
        if (expression.isNullOrEmpty()) throw IllegalArgumentException("null 이거나 빈 공백 문자입니다.")
    }

    private fun checkOperation(content: String) {
        if (isNumber(content).not() && isOperation(content).not()) {
            throw IllegalArgumentException("사칙연산 기호가 아닌 문자가 들어있습니다.")
        }
    }

    private fun isNumber(content: String): Boolean {
        val isIntRegex = Regex("-?\\d+")

        return content.matches(isIntRegex)
    }

    private fun isOperation(content: String): Boolean {
        val isOperationRegex = Regex("[+\\-*/]")

        return content.matches(isOperationRegex)
    }

    private fun plus(first: Int, second: Int): Int = first + second

    private fun minus(first: Int, second: Int): Int = first - second

    private fun multiply(first: Int, second: Int): Int = first * second

    private fun division(first: Int, second: Int): Int = first / second
}
