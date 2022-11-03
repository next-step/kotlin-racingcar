package study

class StringCalculator {

    companion object {

        fun execute(input: String): Long {
            val numbersAndOperators: List<List<String>> = groupByNumberAndOperator(splitInputData(input))
            val stringNumbers: MutableList<StringNumber> =
                numbersAndOperators[0].map { StringNumber(it) }.toMutableList()
            val operators: MutableList<Operator> =
                numbersAndOperators[1].map { Operator.fromDescription(it) }.toMutableList()
            validateListSize(stringNumbers, operators)
            return run(stringNumbers, operators)
        }

        private fun splitInputData(input: String): List<String> {
            return input.split(" ")
        }

        private fun groupByNumberAndOperator(splitStrings: List<String>): List<List<String>> {
            return splitStrings.withIndex()
                .groupBy { it.index % 2 }
                .map { it.value.map { valueIt -> valueIt.value } }
        }

        private fun validateListSize(stringNumbers: List<StringNumber>, operators: List<Operator>) {
            if (stringNumbers.size == operators.size) {
                throw IllegalArgumentException("잘못된 입력입니다.")
            }
        }

        private fun run(stringNumbers: MutableList<StringNumber>, operators: MutableList<Operator>): Long {
            while (operators.isNotEmpty()) {
                val first: StringNumber = stringNumbers.removeFirst()
                val operator: Operator = operators.removeFirst()
                val second: StringNumber = stringNumbers.removeFirst()
                val result: Long = calculate(first, operator, second)
                stringNumbers.add(0, StringNumber(result))
            }
            return stringNumbers.first().num
        }

        private fun calculate(first: StringNumber, operator: Operator, second: StringNumber): Long {
            if (operator.isPlus()) {
                return first.num + second.num
            }
            if (operator.isMinus()) {
                return first.num - second.num
            }
            if (operator.isDivide()) {
                return first.num / second.num
            }
            return first.num * second.num
        }
    }
}
