package carRacing.Domain

import carRacing.Enum.ErrorCode

val VARIABLE_PATTERN: Regex = Regex("\\[\\d+\\]")

class MessageGenerator {
    fun getErrorMessage(errorCode: ErrorCode, vararg variables: String): String {
        var message = errorCode.message

        if (getVariableCount(message) != variables.size) {
            throw IllegalArgumentException("변수의 개수가 일치하지 않습니다.")
        }

        for ((idx, variable) in variables.withIndex()) {
            message.replace("[$idx]", variable)
        }

        return message
    }

    private fun getVariableCount(message: String): Int = VARIABLE_PATTERN.findAll(message).count()
}