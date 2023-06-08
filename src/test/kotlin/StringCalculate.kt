class StringCalculate {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty())
            throw IllegalArgumentException("문자열을 확인해 주세요")

        var firstOperand = ""
        var secondOperand = ""
        var operator: Char? = null

        var operateResult = 0

        input.forEach { c ->
            when (this.parseChar(c)) {
                CharType.NUMBER -> {
                    if (operator == null)
                        firstOperand += c

                    if (firstOperand != "" && operator != null)
                        secondOperand += c
                }

                CharType.BLANK -> {
                    if (firstOperand != "" && secondOperand != "") {
                        operateResult = this.operation(firstOperand, secondOperand, operator!!)
                        firstOperand = operateResult.toString()
                        secondOperand = ""
                        operator = null
                    }
                }

                CharType.OPERATOR -> {
                    operator = c
                }
            }
        }

        // 마지막 원소 계산
        operateResult = this.operation(firstOperand, secondOperand, operator!!)
        return operateResult
    }

    private fun parseChar(c: Char): CharType {
        if (c.code in 48..57)
            return CharType.NUMBER

        if (c == ' ')
            return CharType.BLANK

        if (Operator.values().any { it.operator == c })
            return CharType.OPERATOR

        throw IllegalArgumentException("문자열을 확인해 주세요")
    }

    private fun operation(x: String, y: String, o: Char): Int {
        val operator = Operator.values().find { it.operator == o }
            ?: throw IllegalArgumentException("+ - * / 를 제외한 다른 연산자가 포함되어 있습니다.")

        return when (operator) {
            Operator.PLUS -> this.add(x, y)
            Operator.MINUS -> this.sub(x, y)
            Operator.MULTIPLY -> this.mul(x, y)
            Operator.DIVISION -> this.div(x, y)
        }
    }

    private fun add(x: String, y: String): Int {
        return Integer.valueOf(x) + Integer.valueOf(y)
    }

    private fun sub(x: String, y: String): Int {
        return Integer.valueOf(x) - Integer.valueOf(y)
    }

    private fun mul(x: String, y: String): Int {
        return Integer.valueOf(x) * Integer.valueOf(y)
    }

    private fun div(x: String, y: String): Int {
        return Integer.valueOf(x) / Integer.valueOf(y)
    }
}

enum class Operator(val operator: Char) {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVISION('/')
}

enum class CharType {
    NUMBER,
    BLANK,
    OPERATOR,
}
