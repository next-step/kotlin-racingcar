package racing_car.domain

class RacingGame(
    numberOfCars: Int,
    racingRound: Int,
) {
    private val racingRound: Int = racingRound
    private var currentRacingRound: Int = 0
    val cars: List<Car> = List(numberOfCars) { Car() }

    val isContinuable: Boolean
        get() = currentRacingRound < racingRound

    fun move() {
        cars.forEach(Car::move)
        currentRacingRound++
    }
}
