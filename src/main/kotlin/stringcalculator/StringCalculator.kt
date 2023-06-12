package stringcalculator


class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            require(!input.isNullOrBlank())

            val stringParser = StringParser(input)
            val numbers = stringParser.numbers()
            val operators = stringParser.operators()

            return performOperations(numbers, operators)
        }

        private fun performOperations(numbers: List<Int>, operators: List<String>): Int {
            var result = numbers[0]

            for (i in operators.indices) {
                val operatorSign = operators[i]
                val operand = numbers[i + 1]

                result = Operator.executeOperation(operatorSign, result, operand)
            }

            return result;
        }
    }
}
