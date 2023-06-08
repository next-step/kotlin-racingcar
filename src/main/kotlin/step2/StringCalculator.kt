package step2

import step2.enums.StringOperator

class StringCalculator {
    fun execute(expression: String?): Int {
        requireNotNull(expression)

        val (numbers, operators) = splitListByIndex(
            givenList = expression.split(" ")
        )

        return calculateAll(numbers, operators)
    }

    private fun splitListByIndex(givenList: List<String>): SplitResult {
        val numbers = mutableListOf<Int>()
        val stringOperators = mutableListOf<StringOperator>()

        for ((index, element) in givenList.withIndex()) {
            if (index % 2 == 0) {
                numbers.add(element.toInt())
            } else {
                stringOperators.add(StringOperator.from(element))
            }
        }

        return SplitResult(
            numbers = numbers,
            stringOperators = stringOperators
        )
    }

    private data class SplitResult(
        val numbers: List<Int>,
        val stringOperators: List<StringOperator>
    )

    private fun calculateAll(
        numbers: List<Int>,
        stringOperators: List<StringOperator>
    ): Int {
        var result = numbers[0]

        for (index in 1 until numbers.size) {
            val stringOperator = stringOperators[index - 1]
            result = stringOperator.operation(result, numbers[index])
        }

        return result
    }
}
