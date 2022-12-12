package racingcar.domain

import racingcar.domain.model.CarRacer
import racingcar.domain.model.CarRacingGame

/**
 * 자동차 경주 대회
 */
class FormularOne(
    private val carNames: List<String> = emptyList(),
    private val numberOfGame: Int = 0
) {

    private lateinit var _totalResult: List<List<CarRacer>>
    val totalResult: List<List<CarRacer>>
        get() = _totalResult

    /**
     * 대회 시작
     */
    fun start() {
        require(numberOfGame > 0) { "경주는 1회 이상이어야 합니다" }
        require(carNames.isNotEmpty()) { "자동차 이름이 있어야 합니다" }

        val carRacers: List<CarRacer> = makeCarRacerList(carNames)

        _totalResult = List(numberOfGame) {
            val game = CarRacingGame(carRacers = carRacers)
            game.race()
            game.result()
        }
    }

    fun findWinners(): List<CarRacer> {
        val carRacers: List<CarRacer> = totalResult.last()
        val max: Int = carRacers.maxOf { it.position }
        return carRacers
            .filter { it.position == max }
    }

    /**
     * 자동차 경주자 목록 생성
     */
    private fun makeCarRacerList(carNames: List<String>): List<CarRacer> {
        return carNames.map { name -> CarRacer(name) }
    }
}
