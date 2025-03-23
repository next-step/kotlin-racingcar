package racingcar

import racingcar.car.Cars

class RacingGame(
    private val cars: Cars,
    private val rounds: Int,
) {
    private val gameResult = mutableListOf<RaceResult>()

    constructor(
        carNames: List<String>,
        rounds: Int,
    ) : this(
        Cars.fromNames(carNames),
        rounds,
    )

    val currentResult: List<RaceResult>
        get() = gameResult.toList()

    val winningCarNames: List<String>
        get() = cars.winningCarNames()

    fun start() {
        repeat(rounds) {
            cars.moveAll()
            val roundResult = RaceResult(cars.values)
            gameResult.add(roundResult)
        }
    }
}
