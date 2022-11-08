package step2.converter

import java.lang.NumberFormatException

class StringToInt : ToInt<String> {

    companion object {
        const val ERROR_MESSAGE_INVALID_NUMBER_FORMAT = "Invalid Number Format"
    }

    override fun toInt(value: String): Int =
        try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("$ERROR_MESSAGE_INVALID_NUMBER_FORMAT [$value]")
        }
}
