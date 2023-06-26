package racingcar.domain

import racingcar.domain.movingstrategy.DefaultMovingStrategy
import racingcar.domain.movingstrategy.MovingStrategy

class RacingGame(
    private val round: Int,
    private val carNames: String,
    private val movingStrategy: MovingStrategy = DefaultMovingStrategy(),
) {
    private var histories: MutableList<RoundHistory> = mutableListOf()

    fun run() {
        val cars = Cars.of(carNames, movingStrategy)
        repeat(round) { currentRound ->
            cars.moveAll()
            val roundHistory = RoundHistory(currentRound, cars.getPositions())
            histories.add(roundHistory)
        }
    }

    fun getHistories(): List<RoundHistory> {
        return histories.toList()
    }
}
