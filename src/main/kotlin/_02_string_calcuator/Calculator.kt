package _02_string_calcuator

class Calculator {

    fun calculate(expression: String): Int {
        validateBlank(expression)
        val expressions = expression.split(" ")
        val numbers = expressions.filter { isNumeric(it) }.map { it.toInt() }
        val operators = expressions.filter { !isNumeric(it) }
        val initialNumber = numbers.firstOrNull() ?: 0
        return numbers.drop(1).foldIndexed(initialNumber) {
            index, acc, cur ->
            calculateOperand(operators[index], acc, cur)
        }
    }

    private fun validateBlank(expression: String) = require(expression.isNotBlank()) { "연산을 위한 값을 입력해주세요." }

    private fun isNumeric(string: String): Boolean = string.toIntOrNull() != null

    private fun calculateOperand(operator: String, num1: Int, num2: Int) = Operator.find(operator).calculate(num1, num2)
}
