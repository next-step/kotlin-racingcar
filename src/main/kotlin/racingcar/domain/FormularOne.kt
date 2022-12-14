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

    private lateinit var _totalResult: List<Cars>
    val totalResult: List<Cars>
        get() = _totalResult

    /**
     * 대회 시작
     */
    fun start() {
        val carRacers = carNames.makeCars()

        _totalResult = List(tryGames.count) {
            val game = CarRacingGame(carRacers)
            game.race()
            game.result()
        }
    }

    fun findWinners(): Cars = totalResult.last().findMostFarthestCar()
}
