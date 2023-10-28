package racingcar.domain

class CarRacingGame private constructor(
    private val cars: List<Car>,
    private val rounds: ClosedRange<Int>,
    private val result: CarRacingResult,
) {
    companion object {
        fun set(configuration: CarRacingGameConfiguration, result: CarRacingResult): CarRacingGame = CarRacingGame(
            cars = configuration.cars,
            rounds = configuration.rounds,
            result = result,
        )
    }
}
