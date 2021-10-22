package racingcar.domain

@JvmInline
value class Name(val value: String) {

    init {
        verify()
    }

    private fun verify() {
        require(!value.isNullOrBlank()) { "이름은 null 또는 빈문자열일 수 없습니다." }
        require(value.length <= MAX_LENGTH) { "이름은 최대 ${MAX_LENGTH}를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_LENGTH = 5;
    }
}
