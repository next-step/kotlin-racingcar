package racingcar.domain

@JvmInline
value class CarName(
    val value: String
) {
    init {
        require(value.isNotBlank()) { "자동차의 이름은 공백이 들어올 수 없다" }
        require(value.length < LIMIT_LENGTH) { "자동차의 이름을 $LIMIT_LENGTH 자를 초과할 수 없다" }
    }

    companion object {
        private const val LIMIT_LENGTH = 5
    }
}
