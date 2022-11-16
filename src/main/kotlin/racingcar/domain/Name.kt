package racingcar.domain

@JvmInline
value class Name(val value: String) {
    init {
        require(value.length <= 5) { "이름은 5자를 초과할 수 없습니다." }
    }

    override fun toString(): String {
        return value
    }
}
