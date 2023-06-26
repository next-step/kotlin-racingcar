package racingcar.domain

import racingcar.domain.movingstrategy.DefaultMovingStrategy
import racingcar.domain.movingstrategy.MovingStrategy

class RacingGame(
    private val round: Int,
    private val carNames: String,
    private val movingStrategy: MovingStrategy = DefaultMovingStrategy(),
) {
    private val gameHistory: RacingGameHistory = RacingGameHistory()

    fun run() {
        val cars = Cars.of(carNames, movingStrategy)
        repeat(round) { currentRound ->
            cars.moveAll()
            val roundHistory = RoundHistory(currentRound, cars.getCurrentInfos())
            gameHistory.addHistory(roundHistory)
        }
    }

    fun getHistories(): List<RoundHistory> {
        return gameHistory.getHistories()
    }

    fun getWinnerNames(): List<String> {
        return gameHistory.getWinnerNames()
    }
}
