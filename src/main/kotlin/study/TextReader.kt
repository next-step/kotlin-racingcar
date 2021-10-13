package study

class TextReader(text: String?) {
    companion object {
        private const val BLANK_NOT_ALLOWED = "빈값이 들어갈 수 없습니다"
        private const val DELIMITER = " "
    }

    var result: List<String>

    init {
        if (text == null || text.isBlank()) {
            throw IllegalArgumentException(BLANK_NOT_ALLOWED)
        }
        result = text.split(DELIMITER)
    }
}
