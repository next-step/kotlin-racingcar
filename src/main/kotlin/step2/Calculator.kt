package step2

class Calculator {
    fun calculate(expression: String): Int {
        validateInput(expression)

        val terms = buildTerms(expression)

        return calculate(terms)
    }

    private fun validateInput(expression: String) {
        require(expression.isNotBlank()) { "인자로 전달되는 수식이 공백 문자열입니다!" }
    }

    private fun buildTerms(expression: String) = expression.split(" ")

    private fun calculate(terms: List<String>): Int {
        var result = terms[0].toInt()

        for (i in 1 until terms.size step 2) {
            val operatorSymbol = terms[i]
            val operand = terms[i + 1].toInt()

            result = operate(result, operatorSymbol, operand)
        }
        return result
    }

    private fun operate(result: Int, operatorSymbol: String, operand: Int): Int {
        for (o in Operation.values()) {
            if (operatorSymbol == o.symbol) {
                return o.apply(result, operand)
            }
        }

        throw IllegalArgumentException("$operatorSymbol : 알 수 없는 연산자입니다!")
    }
}
