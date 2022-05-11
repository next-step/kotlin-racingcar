package racinggame.view.validator

object NameLengthValidator : InputValidator<String> {
    private const val MAXIMUM_LENGTH = 5
    private const val INVALID_USER_INPUT_MESSAGE = "자동차 이름은 ${MAXIMUM_LENGTH}자를 초과할 수 없습니다."

    override fun validate(input: String): String {
        return input.also { inputName ->
            require(inputName.length <= MAXIMUM_LENGTH) {
                INVALID_USER_INPUT_MESSAGE
            }
        }
    }
}