package racingcar.domain.cars

data class NumberOfRacingCars(val value: Int) {
    init {
        require(MINIMUM_NUMBER_OF_CAR <= value)
    }

    companion object {
        private const val MINIMUM_NUMBER_OF_CAR = 1
    }
}
