package racingcar.domain

import racingcar.domain.model.CarNames
import racingcar.domain.model.CarRacer
import racingcar.domain.model.CarRacers
import racingcar.domain.model.CarRacingGame

/**
 * 자동차 경주 대회
 */
class FormularOne(
    private val carNames: CarNames = CarNames(),
    private val numberOfGame: Int = 0
) {

    private lateinit var _totalResult: List<CarRacers>
    val totalResult: List<CarRacers>
        get() = _totalResult

    /**
     * 대회 시작
     */
    fun start() {
        require(numberOfGame > 0) { "경주는 1회 이상이어야 합니다" }

        val carRacers = CarRacers.ofCarNames(carNames)

        _totalResult = List(numberOfGame) {
            val game = CarRacingGame(carRacers)
            game.race()
            game.result()
        }
    }

    fun findWinners(): CarRacers = totalResult.last().findWinner()
}
