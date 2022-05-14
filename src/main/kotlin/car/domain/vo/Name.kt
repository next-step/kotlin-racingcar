package car.domain.vo

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotEmpty()) { "이름은 비어 있을수 없습니다." }
    }
}
