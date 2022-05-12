class Calculator {

    companion object {
        fun sum(left: Int, right: Int): Int = left + right
        fun minus(left: Int, right: Int): Int = left - right
        fun multiple(left: Int, right: Int): Int = left * right
        fun division(left: Int, right: Int): Int = left / right
    }
}

class BasicFourCalculator {
    companion object {
        fun stringCalc(left: Int, operator: String, right: Int): Int {
            return when (operator) {
                "+" -> Calculator.sum(left, right)
                "-" -> Calculator.minus(left, right)
                "*" -> Calculator.multiple(left, right)
                "/" -> Calculator.division(left, right)
                else -> {
                    // 사칙연산 기호외의 입력으로 인한 오류
                    println("제공하는 사칙연산 기호가 아닙니다.")
                    throw IllegalArgumentException()
                }
            }
        }
    }
}

class StringCalculator {
    companion object {
        fun calculator(expression: String?): Int {
            checkValidExpression(expression)

            var result = 0
            var operator = ""
            expression?.split(" ")?.forEachIndexed { index, str ->
                if (index == 0) result = str.toInt()
                else when (index % 2) {
                    0 -> { result = BasicFourCalculator.stringCalc(result, operator, str.toInt()) }
                    1 -> { operator = str }
                    else -> {
                        // 연산 오류
                        println("연산 중 오류가 발생했습니다.")
                        throw UnsupportedOperationException()
                    }
                }
            }
            return result
        }

        private fun checkValidExpression(expression: String?) {
            if (expression.isNullOrEmpty()) throw IllegalArgumentException()

            val expressionList = expression.split(" ")

            requireNotNull(expressionList.last().toIntOrNull()) { "연산식의 첫번째 문자는 숫자여야 합니다." }
            requireNotNull(expressionList.last().toIntOrNull()) { "연산식의 마지막 문자는 숫자여야 합니다." }

            expressionList.forEachIndexed { index, exp ->
                val isValid = if (index % 2 == 0) exp.toIntOrNull() != null else isValidOperator(exp)
                if (!isValid) throw IllegalArgumentException()
            }
        }

        private fun isValidOperator(op: String): Boolean {
            return when (op) {
                "+", "-", "*", "/" -> true
                else -> false
            }
        }
    }
}
