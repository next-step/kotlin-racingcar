package calculator

class Calculator {
    fun groupByIsNumber(inputs: List<String>, bool: Boolean): List<String> {
        val elements = inputs.groupBy { (it.toDoubleOrNull() != null) };
        return elements[bool]!!
    }

    fun calculate(input: String): Float {
        val inputs = input.split(" ");
        val numbers = groupByIsNumber(inputs, true).map { it.toFloat() }
        val operations = groupByIsNumber(inputs, false);

        var total = numbers[0]

        for ((index, el) in numbers.drop(1).withIndex()) {
            if (operations[index] == "+") {
                total += el
            }
            else if (operations[index] == "-") {
                total -= el
            }
            else if (operations[index] == "*") {
                total *= el
            }
            else if (operations[index] == "/") {
                total /= el
            }
            else {
                throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }

        }

        return total
    }
}