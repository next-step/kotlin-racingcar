package study

class Calculator(text: String?) {
    init {
        val parsedText = TextReader(text).result
        calculate(parsedText)
    }

    var result = 0

    private fun calculate(parsedText: List<String>) {
        result = startNumber(parsedText)
        for (i in parsedText.indices) {
            calculateWithMatchedOperator(i, parsedText)
        }
    }

    private fun calculateWithMatchedOperator(i: Int, parsedText: List<String>) {
        if (isOperator(i)) {
            checkMathOperator(parsedText[i])
        }
        if (parsedText[i] == "+") {
            result += parsedText[i + 1].toInt()
        }
        if (parsedText[i] == "-") {
            result -= parsedText[i + 1].toInt()
        }
        if (parsedText[i] == "*") {
            result *= parsedText[i + 1].toInt()
        }
        if (parsedText[i] == "/") {
            result /= parsedText[i + 1].toInt()
        }
    }

    private fun startNumber(parsedText: List<String>) = parsedText[0].toInt()

    private fun isOperator(i: Int) = i % 2 == 1

    private fun checkMathOperator(operator: String) {
        val operators = listOf("+", "-", "*", "/")

        if (!operators.contains(operator)) {
            throw IllegalArgumentException("수식이 입력되지 않았습니다")
        }
    }

    fun result(): Int {
        return result
    }
}
