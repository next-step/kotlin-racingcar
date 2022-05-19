package car.domain.vo

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotEmpty()) { "이름은 비어 있을수 없습니다." }
        require(value.length in NAME_RANGE) { "이름은 5자를 초과할수 없습니다." }
    }

    companion object {
        private val NAME_RANGE = 1..5
    }
}
