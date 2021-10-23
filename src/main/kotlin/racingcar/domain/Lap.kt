package racingcar.domain

@JvmInline
value class Lap(private val value: Int) {
    init {
        verify()
    }

    private fun verify() {
        require(value >= MIN_LAPS) { "각 라운드는 ${MIN_LAPS}보다 작을 수 없습니다." }
    }

    companion object {
        private const val MIN_LAPS = 1
    }
}
