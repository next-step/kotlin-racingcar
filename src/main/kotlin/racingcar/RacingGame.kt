package racingcar

import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame private constructor(
    private val numOfCars: Int,
    private val numOfAttempts: Int
) {
    val racingCars: List<Car> =  List(numOfCars) {Car.ofRandom()}

    fun start(): List<Car> {
        ResultView.printResultText()
        repeat(numOfAttempts) {
            racingCars.forEach { it.move() }
            ResultView.printResultState(racingCars)
        }
        return racingCars
    }

    companion object {
        fun of(numOfCars: Int, numOfAttempts: Int): RacingGame {
            return RacingGame(numOfCars, numOfAttempts)
        }
    }
}

fun main() {
    val inputs = InputView.gatherUserInput()
    val racingGame = RacingGame.of(inputs.numOfCars, inputs.numOfAttempts)
    racingGame.start()
}