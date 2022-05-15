package expressioncalculator.calculator

object ExpressionParser {
    private const val DELIMITER = " "

    private const val SIZE_OF_CALCULATION_UNIT = 2

    private const val BLANK_CALCULATION_VALUE_ERROR_MESSAGE = "사칙 연산의 값으로 공백을 사용할 수 없습니다."
    private const val NULL_CALCULATION_VALUE_ERROR_MESSAGE = "연산에 필요한 값이 존재하지 않습니다."

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
        val textSymbol = requireNotNullOrBlank(symbolAndNumber.firstOrNull())
        val textNumber = requireNotNullOrBlank(symbolAndNumber.lastOrNull())

        Calculation(
            operator = Operator.from(textSymbol),
            number = textNumber.toDouble()
        )
    }

    private fun requireNotNullOrBlank(value: String?): String {
        require(value != null) {
            NULL_CALCULATION_VALUE_ERROR_MESSAGE
        }
        require(value.isNotBlank()) {
            BLANK_CALCULATION_VALUE_ERROR_MESSAGE
        }

        return value
    }
}
