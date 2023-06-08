package step2

import step2.enums.Operator

class StringCalculator {
    fun execute(expression: String?): Int {
        requireNotNull(expression)

        val (numbers, operators) = splitListByIndex(
            givenList = expression.split(" ")
        )

        return calculateAll(numbers, operators)
    }

    private fun splitListByIndex(givenList: List<String>): Pair<List<Int>, List<Operator>> {
        val numberList = mutableListOf<Int>()
        val operatorList = mutableListOf<Operator>()

        for ((index, element) in givenList.withIndex()) {
            if (index % 2 == 0) {
                numberList.add(element.toInt())
            } else {
                operatorList.add(Operator.from(element))
            }
        }

        return Pair(numberList, operatorList)
    }

    private fun calculateAll(numbers: List<Int>, operators: List<Operator>): Int {
        var result = numbers[0]

        for (index in 1 until numbers.size) {
            val operator = operators[index - 1]
            result = operator.operation(result, numbers[index])
        }

        return result
    }
}
