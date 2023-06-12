package racingcar.ui.input

class InputValidator {
    fun isNumber(value: String) = value.matches("\\d+".toRegex())
}
