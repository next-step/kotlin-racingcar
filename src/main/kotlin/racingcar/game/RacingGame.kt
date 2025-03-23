package racingcar.game

import racingcar.car.Cars

class RacingGame(
    private val cars: Cars,
    private val round: Round,
) {
    private val gameResult = mutableListOf<RaceResult>()

    constructor(
        carNames: List<String>,
        round: Int,
    ) : this(
        Cars.fromNames(carNames),
        Round(round),
    )

    val currentResult: List<RaceResult>
        get() = gameResult.toList()

    val winningCarNames: List<String>
        get() = cars.winningCarNames()

    fun start() {
        while (round.canContinue) {
            cars.moveAll()
            val roundResult =
                RaceResult(
                    cars.values.map { CarDto(it.position, it.name) },
                )
            gameResult.add(roundResult)
            round.proceed()
        }
    }
}
