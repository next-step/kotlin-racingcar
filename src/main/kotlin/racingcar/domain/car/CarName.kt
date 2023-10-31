package racingcar.domain.car

@JvmInline
value class CarName(
    val value: String,
) {
    init {
        require(this.value.length <= MAX_LENGTH) { "자동차 이름은 5글자를 넘을 수 없습니다" }
    }

    companion object {
        private const val MAX_LENGTH = 5
    }
}
