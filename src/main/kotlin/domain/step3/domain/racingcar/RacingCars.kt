package domain.step3.domain.racingcar

@JvmInline
value class RacingCars(private val racingCars: List<RacingCar>) {
    fun moveForward() = RacingCars(racingCars.map { it.moveForward() })
}
