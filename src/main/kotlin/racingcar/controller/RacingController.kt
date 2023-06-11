package racingcar.controller

import racingcar.model.Car
import racingcar.rule.RacingRule
import racingcar.view.ResultView

class RacingController(private val view: ResultView, private val rule: RacingRule) {
    private val carList = mutableListOf<Car>()

    fun play() {
        val (carCount, turnCount) = view.input()

        initialize(carCount)

        repeat(turnCount) {
            playTurn()
            view.output(carList)
        }
    }

    private fun initialize(carCount: Int) {
        repeat(carCount) {
            carList.add(Car(rule))
        }
    }

    private fun playTurn() {
        carList.forEach { car ->
            car.move()
        }
    }
}
