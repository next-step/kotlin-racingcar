package racingcar.domain

class InputName(input: String) {
    val names: List<String>

    init {
        names = splitInputValue(input)
        for (name in names) {
            if (isBlank(name)) {
                throw IllegalArgumentException("$ERROR_MESSAGE Blank")
            }
            checkValidNameLength(name)
        }
        checkDuplicatedName()
    }

    private fun splitInputValue(inputValue: String): List<String> {
        return inputValue.split(INPUT_VALUE_DELIMITER)
    }

    private fun isBlank(number: String): Boolean {
        return number.isBlank()
    }

    private fun checkValidNameLength(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("$ERROR_MESSAGE Invalid Length")
        }
    }

    private fun checkDuplicatedName() {
        if (names.size != names.distinct().count()) {
            throw IllegalArgumentException("$ERROR_MESSAGE Duplicated Name")
        }
    }

    companion object {
        const val ERROR_MESSAGE = "[ERROR]"
        const val INPUT_VALUE_DELIMITER = ","
    }
}
