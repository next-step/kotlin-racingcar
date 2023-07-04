package racingcar.domain

import racingcar.domain.car.Cars
import racingcar.domain.history.RacingGameHistory
import racingcar.domain.history.RoundHistory
import racingcar.domain.movingstrategy.DefaultMovingStrategy
import racingcar.domain.movingstrategy.MovingStrategy

class RacingGame(
    round: Int,
    private val carNames: String,
    private val movingStrategy: MovingStrategy = DefaultMovingStrategy(),
    private val nameParser: NameParser = NameParser()
) {
    private val gameHistory: RacingGameHistory = RacingGameHistory()
    private val round: Round = Round(round)

    fun run() {
        val parsedNames = nameParser.parse(carNames)
        val cars = Cars.of(movingStrategy, parsedNames)
        repeat(round.value) { currentRound ->
            cars.moveAll()
            val roundHistory = RoundHistory(currentRound, cars.getCurrentInfos())
            gameHistory.addHistory(roundHistory)
        }
    }

    fun getHistories() = gameHistory.getHistories()

    fun getWinnerNames() = gameHistory.getWinnerNames()
}
