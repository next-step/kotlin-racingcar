package racingcar

@JvmInline
value class CarName(
    val value: String,
) {
    init { check(this.value.length <= MAX_NAME_LENGTH) { "자동차 이름은 5 글자를 초과할 수 없습니다." } }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
