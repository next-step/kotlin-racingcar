package step2.converter

import step2.ErrorMessage
import java.lang.NumberFormatException

class StringToInt : ToInt<String> {
    override fun toInt(value: String): Int =
        try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("${ErrorMessage.INVALID_NUMBER_FORMAT} [$value]")
        }
}
