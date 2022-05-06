package step2

class StringCalculator {
    companion object {
        private val FORMULA_REGEX = Regex("\\d([+|\\-|*|/]\\d)*")
        fun calculate(input: String): Int {
            val expressionStr = input.replace(Regex("\\s+"), "")
            if (expressionStr.isEmpty() || FORMULA_REGEX.matchEntire(expressionStr) == null) {
                throw IllegalArgumentException()
            }
            val firstNum: Int = input[0].digitToInt()
            val expression: Expression = parseFormula(expressionStr) ?: return firstNum
            return expression.execute(firstNum)
        }

        private fun parseFormula(formulaStr: String): Expression? {
            var expression: Expression? = null
            for (i: Int in formulaStr.length - 1 downTo 1) {
                if (i % 2 == 1) {
                    continue
                }

                val number = formulaStr[i].digitToInt()
                val calculator = parseExpression(formulaStr[i - 1])
                expression = Expression(number = number, calculator = calculator, nextExpression = expression)
            }
            return expression
        }

        private fun parseExpression(expression: Char): Calculator {
            return when (expression) {
                '+' -> PlusCalculator()
                '-' -> MinusCalculator()
                '*' -> MultipleCalculator()
                '/' -> DivisionCalculator()
                else -> throw IllegalArgumentException()
            }
        }
    }
}
