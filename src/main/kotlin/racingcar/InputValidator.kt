package racingcar

class InputValidator {
    companion object {
        fun checkNaturalNumber(input: String) {
            val number = input.toIntOrNull()
            require((number != null) && (number > 0))
        }
    }
}
