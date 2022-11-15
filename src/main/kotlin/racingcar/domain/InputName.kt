package racingcar.domain

const val INPUT_VALUE_DELIMITER = ","

class InputName(input: String) {
    val name: String
    init {
        if (isBlank(input)) {
            throw IllegalArgumentException("[ERROR] Blank")
        }
        name = input
    }

    private fun isBlank(number: String): Boolean {
        return number.isBlank()
    }
}
