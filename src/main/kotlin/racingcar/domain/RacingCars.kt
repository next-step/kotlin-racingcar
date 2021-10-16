package racingcar.domain

interface RacingCars {
    val value: List<RacingCar>
    fun race(): RacingCars
}
