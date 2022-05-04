package step2

import step2.inspector.mustNot

const val INVALID_INPUT_ERROR_MESSAGE = "\n적합하지 않은 입력값이 전달되었습니다.\n입력값은 공백으로만 이루어져서는 안 됩니다."

fun main() {
    val expression = readlnOrNull()
    mustNot(IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)) {
        expression.isNullOrBlank()
    }
}