class CharParser {
    companion object {
        fun parseChar(c: Char): CharType {
            if (c.code in 48..57)
                return CharType.NUMBER

            if (c == ' ')
                return CharType.BLANK

            if (Operator.values().any { it.operator == c })
                return CharType.OPERATOR

            throw IllegalArgumentException("문자열을 확인해 주세요")
        }
    }
}

enum class CharType {
    NUMBER,
    BLANK,
    OPERATOR,
}
