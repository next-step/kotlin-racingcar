package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.RacingSituation

class RacingCarController(
    private val countOfTry: Int,
    private val racingGame: RacingGame,
) {

    fun start(): List<List<RacingSituation>> {
        val result = List(countOfTry) {
            racingGame.race()
        }

        return result
    }
}
