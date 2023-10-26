package string.calculator.part

import string.calculator.enum.Operator

class Calculator {
    fun calculate(numbers: MutableList<Long>, operator: MutableList<Operator>): Long {
        var result = numbers.removeFirst()

        numbers.forEachIndexed { index, number ->
            when (operator[index]) {
                Operator.PLUS -> result += number
                Operator.MINUS -> result -= number
                Operator.MULTIPLY -> result *= number
                Operator.DIVIDE -> result /= number
            }
        }

        return result
    }
}
