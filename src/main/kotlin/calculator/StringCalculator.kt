package calculator

class StringCalculator(private val value: String) {

    companion object {
        private const val DELIMITER: String = " "
    }

    private val values: List<String>

    init {
        values = validate(value)
    }

    private fun validate(value: String): List<String> {
        if (value.isBlank() || value.isEmpty()) {
            throw IllegalArgumentException()
        }

        return value.split(DELIMITER)
            .toList()
    }

    fun getValues(): List<String> {
        return values.toMutableList()
    }
}
