package calculator.exception

import java.lang.IllegalArgumentException

class InvalidExpressionException : IllegalArgumentException(VALIDATION_MESSAGE) {
    companion object {
        private const val VALIDATION_MESSAGE = "입력값은 null 혹은 공백이 올 수 없습니다."
    }
}
