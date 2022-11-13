package racingcar.model

import racingcar.RandomCountGenerator

/**
 * 자동차 경주
 */
class CarRacingGame(
    private val numberOfGame: Int,
    private val list: List<CarRacer>
) {

    fun start() {
        for (i in 0..numberOfGame) {
            startGame()
        }
    }

    private fun startGame() {
        for (racer in list) {
            racer.move(RandomCountGenerator.generateCount())
        }
    }
}
