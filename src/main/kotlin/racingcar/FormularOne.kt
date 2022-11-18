package racingcar

import racingcar.model.CarRacer
import racingcar.model.CarRacingGame

/**
 * 자동차 경주 대회
 */
class FormularOne {

    /**
     * 대회 시작
     */
    fun start(numberOfCar: Int, numberOfGame: Int): Map<Int, String> {
        if (numberOfCar <= 0 || numberOfGame <= 0) return emptyMap()

        val carRacers: List<CarRacer> = makeCarRacerList(numberOfCar)
        val games = CarRacingGame(numberOfGame = numberOfGame, carRacers = carRacers)
        games.start()

        return games.takeResult()
    }

    /**
     * 자동차 경주자 목록 생성
     */
    private fun makeCarRacerList(numberOfCar: Int): List<CarRacer> {
        return List(numberOfCar) { CarRacer() }
    }
}
