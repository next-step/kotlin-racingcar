package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.RacingSituation
import racingcar.domain.Winner

class RacingCarController(
    private val countOfTry: Int,
    private val racingGame: RacingGame,
) {

    fun start(): List<List<RacingSituation>> {
        return List(countOfTry) {
            racingGame.race()
        }
    }

    fun evaluate(winner: Winner): List<RacingSituation> {
        return winner.evaluate()
    }
}
