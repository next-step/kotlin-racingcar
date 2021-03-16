package racingcar.history

import racingcar.domain.Car

class RacingResultHistory {
    private val racingActionHistories: MutableList<RacingRoundHistory> = mutableListOf()

    fun logging(round: Int, cars: List<Car>) =
        racingActionHistories.add(RacingRoundHistory.of(round, cars))

    fun getResults(): List<RacingRoundHistory> = racingActionHistories.toList()
}
