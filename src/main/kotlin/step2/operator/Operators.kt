package step2.operator

import step2.number.Numbers
import java.util.LinkedList

class Operators(private val operators: List<Operator>) {
    fun calculate(numbers: Numbers): Int {
        validate(numbers)

        val operators = LinkedList(operators)
        val numberQueue = LinkedList(numbers.numbers)

        var sum = 0
        while (operators.isNotEmpty()) {
            val operator = operators.poll()
            sum += operator.operate(numberQueue.poll().value, numberQueue.poll().value)
        }
        return sum
    }

    private fun validate(numbers: Numbers) {
        if (numbers.size() - 1 != operators.size) {
            throw IllegalArgumentException("피연산자의 갯수(${numbers.size()})가 연산자의 갯수(${operators.size})보다 1개 더 많아야 합니다.")
        }
    }
}
