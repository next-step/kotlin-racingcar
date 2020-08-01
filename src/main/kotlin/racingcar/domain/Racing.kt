package racingcar.domain

import racingcar.strategy.Strategy

class Racing(
    private val carNames: List<String>,
    private var tryCount: Int,
    private val strategy: Strategy
) {
    private val racingCars = RacingCars(carNames, strategy)

    internal fun race(): String {
        if (isProgress()) {
            racingCars.moveForwardAll()
            tryCount--
        }
        return racingCars.toString()
    }

    internal fun getWinner() = racingCars.getWinner()

    internal fun isProgress() = tryCount > 0
}
