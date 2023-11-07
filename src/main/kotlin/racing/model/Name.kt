package racing.model

data class Name(
    val value: String
) {
    init {
        require(value.length <= Name.MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없다 : [$value] 은 [${value.length}] 자리 글자 입니다" }
        require(value.isNotEmpty()) { "자동차의 이름은 빈 문자열이 허용되지 않는다" }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }

    override fun toString(): String {
        return value
    }
}
