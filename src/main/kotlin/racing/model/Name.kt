package racing.model

@JvmInline
value class Name(
    private val name: String
) {

    init {
        validateNotBlank(name)
        validateMinLength(name)
    }

    private fun validateNotBlank(name: String) {
        require(name.isNotBlank()) { "이름이 공백일 수 없습니다." }
    }

    private fun validateMinLength(name: String) {
        require(name.length <= MIN_NAME_LENGTH) { "이름이 ${MIN_NAME_LENGTH}자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MIN_NAME_LENGTH = 5
    }
}
