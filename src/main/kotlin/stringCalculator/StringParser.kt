package stringCalculator

import java.lang.NumberFormatException

class StringParser {
    companion object {
        fun parseString(str: String): StringType {
            if (Operator.values().any { it.operator == str })
                return StringType.OPERATOR

            try {
                str.toInt()
                return StringType.NUMBER
            } catch (e: NumberFormatException) {
                throw NumberFormatException("문자열을 확인해 주세요")
            }
        }
    }
}

enum class StringType {
    NUMBER,
    OPERATOR,
}
