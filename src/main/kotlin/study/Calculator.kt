package study

class Calculator(text: String?) {
    var result = 0

    init {
        val parsedText = TextReader(text).result
        calculate(parsedText)
    }

    private fun calculate(chars: List<String>) {
        for (i in chars.indices) {
            if (chars[i] == "+") {
                val beforeNumber = chars[i - 1].toInt()
                val afterNumber = chars[i + 1].toInt()
                result += beforeNumber + afterNumber
            }
            if (chars[i] == "-") {
                val beforeNumber = chars[i - 1].toInt()
                val afterNumber = chars[i + 1].toInt()
                result += beforeNumber - afterNumber
            }
        }
    }

    fun result(): Int {
        return result
    }
}
