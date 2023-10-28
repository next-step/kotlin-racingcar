package racingcar.domain

class CarRacingGame private constructor(
    private val cars: List<Car>,
    private val rounds: ClosedRange<Int>,
) {
    companion object {
        fun set(configuration: CarRacingGameConfiguration): CarRacingGame = CarRacingGame(
            cars = configuration.cars,
            rounds = configuration.rounds,
        )
    }
}
