package racing.domain

@JvmInline
value class CarName(val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }

    override fun toString(): String {
        return name
    }
}
