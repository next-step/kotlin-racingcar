package racingcar.domain

class InputNumber(input: String) {
    val number: Int
    init {
        if (!isInteger(input)) {
            throw IllegalArgumentException()
        }
        number = input.toInt()
    }

    private fun isInteger(number: String): Boolean {
        return try {
            number.toInt()
            true
        } catch (error: NumberFormatException) {
            false
        }
    }
}
