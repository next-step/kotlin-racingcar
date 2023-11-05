package racinggame

import kotlin.random.Random

class RacingCarGame {
    private val racingCarValue: List<Car>
    private val racingGameTryValue: Int

    init {
        InputView().apply {
            racingCarValue = getJoinPlayCar()
            racingGameTryValue = getPlayingGameCount()
        }
    }

    fun playing(): HashMap<String, List<Car>> {
        val resultMap = HashMap<String, List<Car>>()
        repeat(racingGameTryValue) { game ->
            racingCarValue.forEach { car ->
                val driveValue = Random.nextInt(10)
                car.goForward(driveValue)
            }
            resultMap[game.toString()] = racingCarValue.map {
                it.copy().apply {
                    forwardValue = it.forwardValue
                }
            }
        }
        return resultMap
    }
}

fun main() {
    val game = RacingCarGame()
    val result = game.playing()
    ResultView(result).showResult()
}
