package racingcar.domain

class InputNumber(input: String) {
    val number: Int

    init {
        number = input.toInt()
        require(isValidRange()) { "$ERROR_MESSAGE Invalid Range" }
    }

    private fun isValidRange(): Boolean {
        return number > 0
    }

    companion object {
        const val ERROR_MESSAGE = "[ERROR]"
    }
}
