package racingcar.domain

import racingcar.domain.model.CarRacer
import racingcar.domain.model.CarRacingGame

/**
 * 자동차 경주 대회
 */
class FormularOne {

    /**
     * 대회 시작
     */
    fun start(carNames: List<String>, numberOfGame: Int): List<List<CarRacer>> {
        require(numberOfGame > 0)
        require(carNames.isNotEmpty())

        val carRacers: List<CarRacer> = makeCarRacerList(carNames)

        return List(numberOfGame) {
            val game = CarRacingGame(carRacers = carRacers)
            game.race()
            game.result()
        }
    }

    /**
     * 자동차 경주자 목록 생성
     */
    private fun makeCarRacerList(carNames: List<String>): List<CarRacer> {
        return carNames.map { name -> CarRacer(name) }
    }

    companion object {

        fun findWinners(carRacers: List<CarRacer>): List<String> {
            val max: Int = carRacers.maxOf { it.position }
            return carRacers
                .filter { it.position == max }
                .map { it.name }
        }
    }
}
