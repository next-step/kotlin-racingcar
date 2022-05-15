package racinggame.view.validator

object NameLengthValidator : InputValidator<List<String>> {
    private const val MAXIMUM_LENGTH = 5
    private const val INVALID_USER_INPUT_MESSAGE = "자동차 이름은 ${MAXIMUM_LENGTH}자를 초과할 수 없습니다."

    override fun validate(input: List<String>): List<String> {
        return input.also { inputNames ->
            require(isAllNameValid(inputNames)) {
                INVALID_USER_INPUT_MESSAGE
            }
        }
    }

    private fun isAllNameValid(names: List<String>) = names.all { name ->
        name.length <= MAXIMUM_LENGTH
    }
}
