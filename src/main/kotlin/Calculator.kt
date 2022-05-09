class Calculator {

    companion object {
        fun calculate(expression: String?): Int {
            checkValidExpression(expression)
            val (numbers, operators) = splitNumbersAndOperators(expression!!)

            var result = numbers[0]
            operators.forEachIndexed { index, s ->
                when (s) {
                    "+" -> result += numbers[index + 1]
                    "-" -> result -= numbers[index + 1]
                    "*" -> result *= numbers[index + 1]
                    "/" -> result /= numbers[index + 1]
                    else -> throw IllegalArgumentException("사칙연산 기호가 아님")
                }
            }

            return result
        }

        private fun checkValidExpression(expression: String?) {
            if (expression.isNullOrBlank()) throw IllegalArgumentException("잘못된 계산식 입니다")
        }

        fun splitNumbersAndOperators(expression: String): Pair<List<Int>, List<String>> {
            val splitted = expression.split(" ")
            val numbers = splitted.filterIndexed { i, _ -> i % 2 == 0 }
                .map { it.toInt() }
            val operators = splitted.filterIndexed { i, _ -> i % 2 == 1 }

            return Pair(numbers, operators)
        }
    }
}

