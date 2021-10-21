package domain.step4.domain.racingcar

@JvmInline
value class Name(val name: String) {
    init {
        require(name.isNotBlank()) { BLANK_MESSAGE }
        require(name.length <= MAXIMUM) { String.format(OUT_OF_RANGE_MESSAGE, name.length) }
    }

    companion object {
        private const val BLANK_MESSAGE = "이름은 비어있서는 안 됩니다."
        private const val OUT_OF_RANGE_MESSAGE = "이름의 길이는 5를 초과한 %s가 입력되었습니다."
        private const val MAXIMUM = 5
    }
}
