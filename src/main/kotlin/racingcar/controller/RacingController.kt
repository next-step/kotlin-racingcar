package racingcar.controller

import racingcar.model.Car
import racingcar.rule.RacingRule
import racingcar.view.ResultView

class RacingController(private val view: ResultView, private val rule: RacingRule) {
    private val cars = mutableListOf<Car>()

    fun play() {
        val (carCount, turnCount) = view.input()

        initialize(carCount)

        for (turn in 1..turnCount) {
            playTurn()
            view.output(turn, cars)
        }
    }

    private fun initialize(carCount: Int) {
        repeat(carCount) {
            cars.add(Car(rule))
        }
    }

    private fun playTurn() {
        cars.forEach { car ->
            car.move()
        }
    }
}
