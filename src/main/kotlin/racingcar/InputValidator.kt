package racingcar

object InputValidator {
    fun checkNaturalNumber(input: String) {
        val number = input.toIntOrNull()
        require((number != null) && (number > 0))
    }
}
