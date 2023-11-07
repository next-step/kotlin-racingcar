package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.RacingResult

class RacingCarController(
    private val countOfTry: Int,
    private val racingGame: RacingGame,
) {

    fun start(): List<List<RacingResult>> {
        val result = List(countOfTry) {
            racingGame.race()
        }

        return result
    }
}
