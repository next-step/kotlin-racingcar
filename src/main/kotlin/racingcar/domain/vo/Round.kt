package racingcar.domain.vo

@JvmInline
value class Round(private val value: Int) {
    init {
        require(value >= ZERO) { VALUE_UNDER_ZERO_MESSAGE }
    }

    fun decrease(): Round {
        return Round(value - ONE)
    }

    fun isZero(): Boolean {
        return value == ZERO
    }

    companion object {
        private const val VALUE_UNDER_ZERO_MESSAGE = "시도 횟수는 음수일 수 없습니다."
        private const val ZERO = 0
        private const val ONE = 1
    }
}
