package racing.model

@JvmInline
value class Name(
    private val name: String
) {

    init {
        validateNotBlank(name)
    }

    private fun validateNotBlank(name: String) {
        require(name.isNotBlank()) { "이름이 공백일 수 없습니다." }
    }
}
