package step2.calculator

import step2.inspector.mustNot

class ExpressionParser {
    fun parse(expression: String) = expression
        .splitToTextSymbolAndNumbers()
        .convertToCalculations()

    /**
     * [2,+,3,*,4,/,2]와 같이 만들어지는 list 앞에 +를 더해줌으로써 '연산자->숫자'가 반복되는 규칙을 부여한다.
     */
    private fun String.splitToTextSymbolAndNumbers() = listOf(Operator.SYMBOL_PLUS) + this.split(DELIMITER)

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    private fun List<String>.convertToCalculations() = chunked(SIZE_OF_CALCULATION_UNIT) { symbolAndNumber ->
        val textSymbol = symbolAndNumber.getOrNull(INDEX_SYMBOL)
        val textNumber = symbolAndNumber.getOrNull(INDEX_NUMBER)
        mustNot(IllegalArgumentException(INVALID_CALCULATION_VALUE_ERROR_MESSAGE)) {
            textSymbol.isNullOrBlank() || textNumber.isNullOrBlank()
        }

        // 위에서 non-null을 확인했기 때문에 !!를 사용함.
        Calculation(
            operator = Operator.from(textSymbol!!),
            number = textNumber!!.toDouble()
        )
    }

    companion object {
        private const val DELIMITER = " "

        private const val SIZE_OF_CALCULATION_UNIT = 2
        private const val INDEX_SYMBOL = 0
        private const val INDEX_NUMBER = 1

        private const val INVALID_CALCULATION_VALUE_ERROR_MESSAGE = "사칙 연산의 값으로 공백을 사용할 수 없습니다."
    }
}