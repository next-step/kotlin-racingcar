package racingcar.domain.vo

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotBlank()) { "유효하지 않은 자동차 이름입니다." }
        require(value.length <= LENGTH_LIMIT) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        private const val LENGTH_LIMIT = 5
    }
}
