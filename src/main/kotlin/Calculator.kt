class Calculator {

    companion object {
        fun sum(left: Int, right: Int): Int = left + right
        fun minus(left: Int, right: Int): Int = left - right
        fun multiple(left: Int, right: Int): Int = left * right
        fun division(left: Int, right: Int): Int = left / right

        fun stringCalc(left: Int, operator: String, right: Int): Int {
            return when (operator) {
                "+" -> sum(left, right)
                "-" -> minus(left, right)
                "*" -> multiple(left, right)
                "/" -> division(left, right)
                else -> throw IllegalArgumentException()
            }
        }
    }
}

class StringCalculator {
    companion object {
        fun calculator(expression: String?): Int {
            ExpressionValidator.checkExpression(expression)

            var result = 0
            var operator = ""
            expression?.split(" ")?.forEachIndexed { index, str ->
                if (index == 0) result = str.toInt()
                else when (index % 2) {
                    0 -> { result = Calculator.stringCalc(result, operator, str.toInt()) }
                    1 -> { operator = str }
                    else -> throw IllegalArgumentException()
                }
            }
            return result
        }
    }
}

class ExpressionValidator {
    companion object {
        fun checkExpression(expression: String?) {
            checkValidExpression(expression)
            checkValidOrder(expression)
        }

        private fun checkValidExpression(expression: String?) {
            if (expression.isNullOrEmpty()) throw IllegalArgumentException()
        }

        private fun isValidOperator(op: String): Boolean {
            return when (op) {
                "+", "-", "*", "/" -> true
                else -> false
            }
        }

        private fun checkValidOrder(expression: String?) {
            val expressionList = expression?.split(" ") ?: ArrayList()

            if (expressionList.first().toIntOrNull() == null) throw IllegalArgumentException()
            if (expressionList.last().toIntOrNull() == null) throw IllegalArgumentException()

            expressionList.forEachIndexed { index, exp ->
                val isValid = if (index % 2 == 0) exp.toIntOrNull() != null else isValidOperator(exp)
                if (!isValid) throw IllegalArgumentException()
            }
        }
    }
}
