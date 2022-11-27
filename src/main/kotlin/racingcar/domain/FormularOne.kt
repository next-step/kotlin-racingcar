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
    fun start(numberOfCar: Int, numberOfGame: Int): List<List<CarRacer>> {
        val totalList: MutableList<List<CarRacer>> = mutableListOf()

        if (numberOfCar <= 0 || numberOfGame <= 0) return totalList

        val carRacers: List<CarRacer> = makeCarRacerList(numberOfCar)

        repeat(numberOfGame) {
            val game = CarRacingGame(carRacers = carRacers)
            game.race()
            totalList.add(game.result())
        }

        return totalList
    }

    /**
     * 자동차 경주자 목록 생성
     */
    private fun makeCarRacerList(numberOfCar: Int): List<CarRacer> {
        return List(numberOfCar) { CarRacer() }
    }
}
