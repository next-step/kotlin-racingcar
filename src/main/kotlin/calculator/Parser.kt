package calculator

object Parser {
    fun parse(lexer: Lexer): Double {
        val number = lexer.next()

        if (number !is Token.Number) {
            throw IllegalArgumentException("유효하지 않은 숫자입니다: $number")
        }

        return calculate(number.value, lexer)
    }

    private tailrec fun calculate(current: Double, lexer: Lexer): Double {
        if (lexer.isEOF()) {
            return current
        }

        val operator = lexer.next()
        val nextNumber = lexer.next()

        if (nextNumber !is Token.Number) {
            throw IllegalArgumentException("유효하지 않은 숫자입니다: $nextNumber")
        }

        return when (operator) {
            is Token.Plus -> calculate(current + nextNumber.value, lexer)
            is Token.Minus -> calculate(current - nextNumber.value, lexer)
            is Token.Asterisk -> calculate(current * nextNumber.value, lexer)
            is Token.Slash -> calculate(current / nextNumber.value, lexer)
            else -> throw IllegalArgumentException("유효하지 않은 연산자입니다: $operator")
        }
    }
}
