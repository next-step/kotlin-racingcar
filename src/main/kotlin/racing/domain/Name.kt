package racing.domain

@JvmInline
value class Name(val value: String) {
    init {
        require(value.length <= NAME_LENGTH_LIMIT) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    companion object {
        val ANONY = Name("Anony")
        const val NAME_LENGTH_LIMIT = 5
    }

    override fun toString(): String = value
}
