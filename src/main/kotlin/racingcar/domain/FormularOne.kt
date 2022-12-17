package racingcar.domain

import racingcar.domain.model.CarNames
import racingcar.domain.model.CarRacingGame
import racingcar.domain.model.Cars

/**
 * 자동차 경주 대회
 */
class FormularOne(
    private val carNames: CarNames,
    private val tryGames: TryGames
) {

    private lateinit var _totalResult: GameResults
    val totalResult: GameResults
        get() = _totalResult

    /**
     * 대회 시작
     */
    fun start() {
        val cars: Cars = carNames.makeCars()

        _totalResult = GameResults(
            List(tryGames.count) {
                val game = CarRacingGame(cars)
                game.race()
                game.result()
            }
        )
    }

    fun findWinners(): Cars {
        return totalResult.findMostFarthestCar()
    }
}
