package calculator.io

import calculator.domain.Operator

/**
 * 입력 유효성 검증
 */
class InputValidator {

    fun validate(text: String?): String {
        val notNullOrBlank = validateNullOrBlank(text)
        return isFourArithmeticOperations(notNullOrBlank)
    }

    private fun validateNullOrBlank(text: String?): String {
        if (text.isNullOrBlank()) throw IllegalArgumentException("입력값이 Blank이거나 null이 되면 안됩니다.")
        return text
    }

    private fun isFourArithmeticOperations(text: String): String {

        val toCharArray = text.toCharArray()

        for (c in toCharArray) {
            if (!c.isDigit() && !c.isWhitespace()) {
                Operator.findOperate(c)
            }
        }

        return text
    }
}
