package racingcar.domain

class CarRacingGame private constructor(
    private val cars: List<Car>,
    private val roundRange: IntRange,
    private val result: CarRacingResult,
    private val moveRule: MoveRule,
) {
    fun run(): CarRacingResult {
        roundRange.forEach { roundNumber ->
            runRound()
        }
        return result
    }

    private fun runRound() {
        val round = CarRacingGameRound(
            cars = cars,
            moveRule = moveRule,
        )
        round.run()
    }

    companion object {
        fun set(
            configuration: CarRacingGameConfiguration,
            result: CarRacingResult,
            moveRule: MoveRule,
        ): CarRacingGame = CarRacingGame(
            cars = configuration.cars,
            roundRange = configuration.rounds,
            result = result,
            moveRule = moveRule,
        )
    }
}
