package racingcar.domain

private const val MIN_TRY_NUMBER = 1
private const val USE_COMPLETED_TRY_NUMBER = 0

class TryNumber(value: Int) {
    var value: Int = value
        private set

    val isPlaying: Boolean
        get() = value != USE_COMPLETED_TRY_NUMBER

    init {
        require(value >= MIN_TRY_NUMBER) { "시도횟수는 1이상인 수만 입력받을 수 있습니다. value = $value" }
    }

    fun consume() {
        if (!this.isPlaying) {
            throw IllegalStateException("잔여 시도횟수가 없습니다.")
        }

        this.value--
    }
}
