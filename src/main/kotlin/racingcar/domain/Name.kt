package racingcar.domain

@JvmInline
value class Name(
    val value: String,
) {
    companion object {
        private const val MAX_LENGTH = 5

        fun of(str: String): Name {
            require(str.length <= MAX_LENGTH) {
                throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
            }
            return Name(str)
        }
    }
}
