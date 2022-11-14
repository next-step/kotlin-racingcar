package racingcar.input.value

private const val MINIMUM_NUM_OF_CARS = 1

data class NumberOfCars(val value: Int) {
    init {
        require(value > MINIMUM_NUM_OF_CARS) { "자동차 대수는 1보다 커야 합니다." }
    }
}
