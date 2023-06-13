package racingcar.domain

@JvmInline
value class CarName(
    val name: String
) {
    companion object {
        const val CAR_NAME_LENGTH_THRESHOLD = 5
    }

    init {
        validateNameLength()
    }

    private fun validateNameLength() {
        require(name.length > CAR_NAME_LENGTH_THRESHOLD) {
            "자동차 이름은 ${CAR_NAME_LENGTH_THRESHOLD}자를 초과할 수 없습니다."
        }
    }
}
