package racingcar.view.input.validator

interface InputValidator<T> {
    fun parseValue(inputString: String?): T
}
