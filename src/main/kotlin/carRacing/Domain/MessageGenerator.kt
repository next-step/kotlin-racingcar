package carRacing.Domain

import carRacing.Enum.ErrorCode

val VARIABLE_PATTERN: Regex = Regex("\\[\\d+\\]")

class MessageGenerator {
    fun getErrorMessage(errorCode: ErrorCode, vararg variables: String): String {
        var message = errorCode.message

        if (getVariableCount(message) != variables.size) {
            throw IllegalArgumentException(getErrorMessage(ErrorCode.MISMATCHED_VARIABLE_COUNT))
        }

        for ((idx, variable) in variables.withIndex()) {
            message = message.replace("[$idx]", variable)
        }

        return message
    }

    private fun getVariableCount(message: String): Int = VARIABLE_PATTERN.findAll(message).count()
}