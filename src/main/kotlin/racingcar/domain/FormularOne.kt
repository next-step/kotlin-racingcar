package racingcar.domain

import calculator.Parser
import racingcar.domain.model.CarRacer
import racingcar.domain.model.CarRacingGame

/**
 * 자동차 경주 대회
 */
class FormularOne {

    /**
     * 대회 시작
     */
    fun start(carNameStrings: String, numberOfGame: Int): List<List<CarRacer>> {
        val totalList: MutableList<List<CarRacer>> = mutableListOf()

        if (carNameStrings.isEmpty() || numberOfGame <= 0) return totalList

        val carNames: List<String> = Parser().parse(input = carNameStrings, delimiter = ",")
        val carRacers: List<CarRacer> = makeCarRacerList(carNames)

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
    private fun makeCarRacerList(carNames: List<String>): List<CarRacer> {
        return carNames.map { name -> CarRacer(name) }
    }
}
