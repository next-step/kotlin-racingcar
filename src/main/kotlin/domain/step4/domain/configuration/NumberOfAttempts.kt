package domain.step4.domain.configuration

@JvmInline
value class NumberOfAttempts(val numberOfAttempts: Int) {
    init {
        require(numberOfAttempts >= MINIMUM) { String.format(OUT_OF_RANGE_MESSAGE, numberOfAttempts) }
    }

    constructor(numberOfAttempts: String) : this(numberOfAttempts.toInt())

    companion object {
        private const val MINIMUM = 1
        private const val OUT_OF_RANGE_MESSAGE = "NumberOfAttempts 가 허용하는 범위 밖의 숫자 %s가 입력 되었습니다."
    }
}
