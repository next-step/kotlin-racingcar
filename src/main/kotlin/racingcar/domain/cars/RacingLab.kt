package racingcar.domain.cars

data class RacingLab(val value: Int) {
    init {
        require(START_LAB <= value)
    }

    companion object {
        private const val START_LAB = 0
    }
}
