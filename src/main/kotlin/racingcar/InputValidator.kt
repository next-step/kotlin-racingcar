package racingcar

class InputValidator {
    companion object {
        fun isNaturalNumber(input: String): Boolean {
            val number = input.toIntOrNull()
            return (number != null) && (number > 0)
        }
    }
}
