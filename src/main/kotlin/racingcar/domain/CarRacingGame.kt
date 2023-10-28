package racingcar.domain

class CarRacingGame private constructor(
    private val cars: List<Car>,
    private val rounds: IntRange,
    private val result: CarRacingResult,
    private val moveRule: MoveRule,
) {
    companion object {
        fun set(
            configuration: CarRacingGameConfiguration,
            result: CarRacingResult,
            moveRule: MoveRule,
        ): CarRacingGame = CarRacingGame(
            cars = configuration.cars,
            rounds = configuration.rounds,
            result = result,
            moveRule = moveRule,
        )
    }
}
