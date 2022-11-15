package racingcar.model

import racingcar.RandomCountGenerator

/**
 * 자동차 경주
 */
class CarRacingGame(
    private val numberOfGame: Int,
    private val carRacers: List<CarRacer>
) {

    private val resultGames: MutableMap<Int, String> = mutableMapOf()

    fun start() {
        for (i in 1..numberOfGame) {
            startGame()
            saveResult(i)
        }
    }

    private fun startGame() {
        carRacers.forEach { racer ->
            val position = RandomCountGenerator().generateCount()
            racer.moveTo(position)
        }
    }

    private fun saveResult(numberOfGame: Int) {
        var result = ""
        carRacers.forEachIndexed { index, racer ->
            result += if (index != carRacers.size - 1) {
                racer.path + "\n"
            } else {
                racer.path
            }
        }

        resultGames[numberOfGame] = result
    }

    fun takeResult(): Map<Int, String> {
        return resultGames
    }
}
