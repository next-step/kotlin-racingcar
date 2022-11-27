package step2.converter

import step2.ErrorMessage

class StringToInt : ToInt<String> {
    override fun toInt(value: String): Int =
        try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("${ErrorMessage.INVALID_NUMBER_FORMAT} [$value]")
        }
}
