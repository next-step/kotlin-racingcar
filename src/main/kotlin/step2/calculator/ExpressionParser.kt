package step2.calculator

import step2.inspector.mustNot

class ExpressionParser {
    fun parse(expression: String) = expression
        .splitToTextSymbolAndNumbers()
        .convertToCalculations()

    /**
     * expression은 "2 + 3 * 4 / 2"와 같은 형태로 들어 온다.
     * 이를 split하면 [2,+,3,*,4,/,2] 모양의 list를 얻을 수 있는데,
     * list 맨 앞에 +를 더해줌으로써 '연산자->숫자'가 반복되는 규칙을 부여한다.
     */
    private fun String.splitToTextSymbolAndNumbers() = listOf(Operator.SYMBOL_PLUS) + this.split(DELIMITER)

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    private fun List<String>.convertToCalculations() = chunked(SIZE_OF_CALCULATION_UNIT) { symbolAndNumber ->
        val textSymbol = requireNotNull(symbolAndNumber.firstOrNull()) {
            NULL_CALCULATION_VALUE_ERROR_MESSAGE
        }
        val textNumber = requireNotNull(symbolAndNumber.lastOrNull()) {
            NULL_CALCULATION_VALUE_ERROR_MESSAGE
        }
        mustNot(IllegalArgumentException(BLANK_CALCULATION_VALUE_ERROR_MESSAGE)) {
            textSymbol.isBlank() || textNumber.isBlank()
        }

        // 위에서 non-null을 확인했기 때문에 !!를 사용함.
        Calculation(
            operator = Operator.from(textSymbol),
            number = textNumber.toDouble()
        )
    }

    companion object {
        private const val DELIMITER = " "

        private const val SIZE_OF_CALCULATION_UNIT = 2
        private const val INDEX_SYMBOL = 0
        private const val INDEX_NUMBER = 1

        private const val BLANK_CALCULATION_VALUE_ERROR_MESSAGE = "사칙 연산의 값으로 공백을 사용할 수 없습니다."
        private const val NULL_CALCULATION_VALUE_ERROR_MESSAGE = "연산에 필요한 값이 존재하지 않습니다."
    }
}
