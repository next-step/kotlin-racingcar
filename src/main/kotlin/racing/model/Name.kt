package racing.model

@JvmInline
value class Name(
    val name: String
) {

    init {
        validateNotBlank(name)
        validateMaxLength(name)
    }

    private fun validateNotBlank(name: String) {
        require(name.isNotBlank()) { "이름이 공백일 수 없습니다." }
    }

    private fun validateMaxLength(name: String) {
        require(name.length <= MAX_NAME_LENGTH) { "이름이 ${MAX_NAME_LENGTH}자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
