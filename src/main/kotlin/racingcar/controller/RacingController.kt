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
        val (names, turnCount) = try {
            view.input()
        } catch (e: IllegalArgumentException) {
            view.printMessage("입력 값이 잘못되어 프로그램을 종료합니다")
            return
        }

        initialize(names)

        for (turn in 1..turnCount) {
            playTurn()
            view.output(turn, cars)
        }
    }

    private fun initialize(names: List<String>) {
        for (name in names) {
            cars.add(Car(rule))
        }
    }

    private fun playTurn() {
        cars.forEach { car ->
            car.move()
        }
    }
}
