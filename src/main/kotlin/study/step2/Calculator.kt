package study.step2

class Calculator {

    companion object {
        fun calculate(expression: String?): Double {
            requireValidExpression(expression)
            val (numbers, operators) = splitNumbersAndOperators(expression!!)

            var result = numbers[0]
            operators.forEachIndexed { index, s ->
                when (s) {
                    "+" -> result += numbers[index + 1]
                    "-" -> result -= numbers[index + 1]
                    "*" -> result *= numbers[index + 1]
                    "/" -> result /= numbers[index + 1].apply {
                        if (this == 0.0) throw throw IllegalArgumentException("잘못된 계산식 입니다")
                    }
                    else -> throw IllegalArgumentException("사칙연산 기호가 아님")
                }
            }

            return result
        }

        private fun requireValidExpression(expression: String?) {
            if (expression.isNullOrBlank()) throw IllegalArgumentException("잘못된 계산식 입니다")
        }

        fun splitNumbersAndOperators(expression: String): Pair<List<Double>, List<String>> {
            val splitted = expression.split(" ")
            val operands = splitted.filterIndexed { i, _ -> i % 2 == 0 }
                .map { it.toDouble() }
            val operators = splitted.filterIndexed { i, _ -> i % 2 == 1 }

            return operands to operators
        }
    }
}
