package carGame.domain

@JvmInline
value class CarName(val value: String) {
    init {
        require(value.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자를 초과할 수 없습니다." }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
    }
}
