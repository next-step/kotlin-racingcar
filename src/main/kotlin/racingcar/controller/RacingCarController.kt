package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.RacingSituations
import racingcar.domain.Winner
import kotlin.random.Random

class RacingCarController(
    private val countOfTry: Int,
    private val carNames: List<String>,
    private val racingGame: RacingGame,
) {

    fun start(): List<RacingSituations> {
        val cars = carNames.map {
            Car(it)
        }

        return List(countOfTry) {
            RacingSituations(
                cars.map {
                    racingGame.race(it, random.nextInt(RANDOM_MAX_VALUE))
                }
            )
        }
    }

    fun evaluate(winner: Winner): RacingSituations {
        return winner.evaluate()
    }

    companion object {
        private const val RANDOM_MAX_VALUE = 10
        private val random = Random.Default
    }
}
