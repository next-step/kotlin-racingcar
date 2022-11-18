package racingcar

import racingcar.model.CarRacer
import racingcar.model.CarRacingGame

/**
 * 자동차 경주 대회
 */
class FormularOne {

    private var totalResult: String = ""

    /**
     * 대회 시작
     */
    fun start(numberOfCar: Int, numberOfGame: Int): String {
        if (numberOfCar <= 0 || numberOfGame <= 0) return ""

        val carRacers: List<CarRacer> = makeCarRacerList(numberOfCar)

        for (i in 1..numberOfGame) {
            val game = CarRacingGame(carRacers = carRacers)
            game.start()
            totalResult += (saveGameResult(game.result()) + "\n")
        }

        return totalResult
    }

    private fun saveGameResult(carRacers: List<CarRacer>): String {
        var gameResult = ""
        carRacers
            .forEach { racer ->
                repeat(racer.position) { gameResult += "-" }
                gameResult += "\n"
            }
        return gameResult
    }

    /**
     * 자동차 경주자 목록 생성
     */
    private fun makeCarRacerList(numberOfCar: Int): List<CarRacer> {
        return List(numberOfCar) { CarRacer() }
    }
}
