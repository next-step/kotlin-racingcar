package _02_string_calcuator

class Calculator {

    fun calculate(expression: String): Int {
        validateBlank(expression)

        val expressions = expression.split(" ")
        val numbers = expressions.filterIndexed { index, _ -> isEven(index) }.map { it.toInt() }
        val operators = expressions.filterIndexed() { index, _ -> isOdd(index) }

        val initialNumber = numbers.firstOrNull() ?: 0

        return numbers.drop(1).foldIndexed(initialNumber) {
            index, acc, cur ->
            calculateOperand(operators[index], acc, cur)
        }
    }

    fun calculate(vararg expressions: String) = calculate(expressions.joinToString(" "))

    private fun validateBlank(expression: String) = require(expression.isNotBlank()) { "연산을 위한 값을 입력해주세요." }

    private fun isEven(num: Int) = num % 2 == 0

    private fun isOdd(num: Int) = num % 2 == 1

    private fun calculateOperand(operator: String, num1: Int, num2: Int) = Operator.find(operator).calculate(num1, num2)
}
