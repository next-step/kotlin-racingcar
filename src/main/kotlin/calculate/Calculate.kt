package calculate

import java.util.ArrayDeque
import java.util.Deque
import java.util.stream.Collectors

class Calculate(private val validations: List<CalculateValidation>) {

    constructor() : this(listOf(EmptyCheckValidation(), OperatorValidation()))

    fun calculate(input: String): Int {
        validateInput(input)
        val operators = input.split("\\d+".toRegex()).filter { it.isNotBlank() }
        val numbers: Deque<Int> = extractAndConvertNumber(input, operators)
        for (operator in operators) {
            val operatedValue = operatate(numbers, operator)
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
        var result = input.split(*operators.toTypedArray())
        return result.stream()
            .map(String::trim)
            .map(String::toInt)
            .collect(Collectors.toCollection { ArrayDeque() })
    }

    private fun operatate(numbers: Deque<Int>, operator: String): Int {
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
        if (first == 0) {
            return 0
        }
        if (second == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        return first / second
    }
}
