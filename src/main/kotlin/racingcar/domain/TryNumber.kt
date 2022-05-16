package racingcar.domain

private const val MIN_TRY_NUMBER = 0
private const val USE_COMPLETED_TRY_NUMBER = 0

@JvmInline
value class TryNumber(val value: Int) {
    val isPlaying: Boolean
        get() = value > USE_COMPLETED_TRY_NUMBER

    init {
        require(value >= MIN_TRY_NUMBER) { "시도횟수는 0이상인 수만 입력받을 수 있습니다. value = $value" }
    }

    fun consume(): TryNumber {
        if (!this.isPlaying) {
            throw IllegalStateException("잔여 시도횟수가 없습니다.")
        }

        return TryNumber(value - 1)
    }
}
