package domain.step3.domain.configuration

class NumberOfAttempts(val numberOfAttempts: Int) {
    init {
        require(numberOfAttempts >= MINIMUM) { OUT_OF_RANGE_MESSAGE }
    }

    constructor(numberOfAttempts: String) : this(numberOfAttempts.toInt())

    companion object {
        private const val MINIMUM = 0
        private const val OUT_OF_RANGE_MESSAGE = "NumberOfAttempts 가 허용하는 범위 밖의 숫자가 입력 되었습니다."
    }
}
