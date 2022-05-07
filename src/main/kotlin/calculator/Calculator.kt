package calculator

class Calculator {

    fun calculate(expression: String?): Int {

        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("잘못된 식입니다. ($expression)")
        }

        val tokens = expression.split(DELIMITER)
        var result = tokens[0].toInt()
        for (i in 1 until tokens.size step 2) {
            val operator = Operator.of(tokens[i])
            result = operator.operate(result, tokens[i + 1].toInt())
        }

        return result
    }

    companion object {
        const val DELIMITER = " "
    }
}
