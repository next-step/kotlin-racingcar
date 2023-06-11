package racingcar.controller

import racingcar.model.Car
import racingcar.rule.RacingRule
import racingcar.rule.RacingRuleImpl
import racingcar.view.ResultView
import racingcar.view.ResultViewImpl

class RacingController(
    private val view: ResultView = ResultViewImpl(),
    private val rule: RacingRule = RacingRuleImpl(),
) {
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
