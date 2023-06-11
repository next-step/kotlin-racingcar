package calculate

import java.util.ArrayDeque
import java.util.Deque

class Calculate(private val validations: List<CalculateValidation>) {

    constructor() : this(listOf(EmptyCheckValidation(), OperatorValidation()))

    fun calculate(input: String): Int {
        validateInput(input)
        val operators = input.split("\\d+".toRegex()).filter { it.isNotBlank() }
        val numbers = extractAndConvertNumber(input, operators)
        for (operator in operators) {
            val operatedValue = operate(numbers, operator)
            numbers.addFirst(operatedValue)
        }
        return numbers.pop()
    }

    private fun validateInput(input: String) {
        validations.forEach {
            it.validate(input)
        }
    }

    private fun extractAndConvertNumber(input: String, operators: List<String>): Deque<Int> {
        val result = input.split(*operators.toTypedArray())
        return result
            .map(String::trim)
            .map(String::toInt)
            .toCollection(ArrayDeque())
    }

    private fun operate(numbers: Deque<Int>, operator: String): Int {
        val first = numbers.pop()
        val second = numbers.pop()
        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            "/" -> divide(first, second)
            else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }

    private fun divide(first: Int, second: Int): Int {
        if (second == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        return first / second
    }
}
