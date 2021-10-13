package study

class Calculator(text: String?) {
    init {
        val parsedText = TextReader(text).result
        calculate(parsedText)
    }

    var result = 0

    private fun calculate(parsedText: List<String>) {
        result = parsedText[0].toInt()
        for (i in parsedText.indices) {
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
    }

    fun result(): Int {
        return result
    }
}
