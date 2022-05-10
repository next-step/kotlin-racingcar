package calculator

object Calculator {
    fun calculate(lexer: Lexer): Double {
        val number = lexer.next()

        require(number is Token.Number) { "유효하지 않은 숫자입니다: $number" }

        return process(number.value, lexer)
    }

    private tailrec fun process(current: Double, lexer: Lexer): Double {
        if (lexer.isEOF()) {
            return current
        }

        val operatorToken = lexer.next()
        val nextNumber = lexer.next()

        require(nextNumber is Token.Number) { "유효하지 않은 숫자입니다: $nextNumber" }

        return when (operatorToken) {
            is Token.Plus -> process(current + nextNumber.value, lexer)
            is Token.Minus -> process(current - nextNumber.value, lexer)
            is Token.Asterisk -> process(current * nextNumber.value, lexer)
            is Token.Slash -> process(current / nextNumber.value, lexer)
            else -> throw IllegalArgumentException("유효하지 않은 연산자입니다: $operatorToken")
        }
    }
}
