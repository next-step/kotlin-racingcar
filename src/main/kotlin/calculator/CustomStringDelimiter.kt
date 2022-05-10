package calculator

class CustomStringDelimiter(value: String?) {

    companion object {
        private const val DELIMITER: String = " "
    }

    private val values: List<String>

    init {
        values = validate(value)
    }

    private fun validate(value: String?): List<String> {
        if (value == null) {
            throw IllegalArgumentException("잘못된 값이 전달되었습니다.")
        }

        if (value.isBlank() || value.isEmpty()) {
            throw IllegalArgumentException("잘못된 값이 전달되었습니다.")
        }

        return value.split(DELIMITER)
            .toList()
    }

    fun getValues(): List<String> {
        return values.toMutableList()
    }
}
