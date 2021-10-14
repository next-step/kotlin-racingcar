package calculator

class CalculatorResources {
    companion object {
        private const val PLUS: String = "+"
        private const val MINUS: String = "-"
        private const val MULTIPLY: String = "*"
        private const val DIVISION: String = "/"
        const val SYMBOL_NOT_RIGHT: String = "사칙연산 기호가 아닙니다."
        const val IS_NOT_OR_BLANK: String = "입력값이 null 이거나 빈 공백 문자입니다."
        const val DELIMITER: String = " "

        val operationType = arrayOf(
            MINUS,
            PLUS,
            MULTIPLY,
            DIVISION
        )
    }
}
