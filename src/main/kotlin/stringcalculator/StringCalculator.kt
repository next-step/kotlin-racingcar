package stringcalculator


class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            require(!input.isNullOrBlank())

            val stringParser = StringParser(input)
            val numbers = stringParser.numbers()
            val operators = stringParser.operators()

            val result = numbers[0]
            for (i in operators.indices) {
                calculateOperator(operators, i)
            }
            return result
        }

        private fun calculateOperator(operators: List<String>, i: Int) {
            when (operators[i]) {
                "+" -> Operator.PLUS
                "-" -> Operator.MINUS
                "*" -> Operator.TIMES
                "/" -> Operator.DIVIDE
            }
        }
    }
}
