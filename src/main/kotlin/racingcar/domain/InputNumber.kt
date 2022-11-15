package racingcar.domain

class InputNumber(input: String) {
    val number: Int

    init {
        number = input.toInt()
        require(isValidRange()) { "[ERROR] Invalid Range" }
    }

    private fun isValidRange(): Boolean {
        return number > 0
    }
}
