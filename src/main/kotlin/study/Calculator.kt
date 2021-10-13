package study

class Calculator(text: String?) {
    companion object {
        private const val BLANK_NOT_ALLOWED = "빈값이 들어갈 수 없습니다"
        private const val DELIMITER = " "
    }

    var result = 0

    init {
        if (text == null || text.isBlank()) {
            throw IllegalArgumentException(BLANK_NOT_ALLOWED)
        }
        val chars = text.split(DELIMITER)
        for (i in chars.indices) {
            if (chars[i] == "+") {
                val beforeNumber = chars[i - 1].toInt()
                val afterNumber = chars[i + 1].toInt()
                result += beforeNumber + afterNumber
            }
        }
    }

    fun result(): Int {
        return result
    }
}
