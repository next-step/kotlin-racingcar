package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.RacingSituation
import racingcar.domain.Winner
import racingcar.strategy.RandomMoveStrategy

class RacingCarController(
    private val countOfTry: Int,
    private val carNames: List<String>,
    private val racingGame: RacingGame,
) {

    fun start(): List<RacingSituation> {
        val cars = carNames.map {
            Car(it, RandomMoveStrategy())
        }

        return List(countOfTry) {
            RacingSituation(racingGame.race(cars))
        }
    }

    fun evaluate(winner: Winner): RacingSituation {
        return winner.evaluate()
    }
}
