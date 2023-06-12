package calculator

import calculator.exception.IllegalExpressionException

class Expression(expression: String) {
    private var splitedExpression: List<String>
    var numbers: List<Float>
    var arithmeticSymbols: List<String>

    private val blankRegex = Regex(" +")
    private val numberRegex = Regex("\\d+(\\.\\d+)?")
    private val allowedCharacter = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/")

    init {
        if (expression.isBlank()) {
            throw IllegalExpressionException("표현식이 비어있습니다.")
        }

        splitedExpression = splitByBlank(expression)
        numbers = splitedExpression.filter { isNumber(it) }.map { it.toFloat() }
        arithmeticSymbols = splitedExpression.filter { isOperator(it) }
        validate()
    }

    private fun splitByBlank(expression: String): List<String> {
        return expression.split(blankRegex)
    }

    private fun isNumber(input: String): Boolean {
        return numberRegex.matches(input)
    }

    private fun isOperator(input: String): Boolean {
        return input in StringCalculator.symbolToFunction
    }

    private fun validate() {
        if (splitedExpression.any { it !in allowedCharacter }) {
            throw IllegalExpressionException("숫자와 기호외의 문자가 포함되었습니다.")
        }

        if (numbers.size != arithmeticSymbols.size + 1) {
            throw IllegalExpressionException("숫자는 기호보다 1개 많아야 합니다.")
        }
    }
}
