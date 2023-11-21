package study.domain

@JvmInline
value class CarName(private val name: String) {
    init {
        validateLength()
    }

    private fun validateLength() {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }

    override fun toString(): String {
        return name
    }
}
