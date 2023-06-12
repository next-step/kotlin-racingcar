package racingcar.controller

import racingcar.domain.model.Car
import racingcar.domain.model.GameSetting
import racingcar.domain.model.InputResult
import racingcar.domain.rule.RacingRule
import racingcar.domain.rule.RacingRuleImpl
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.view.ResultView
import racingcar.view.ResultViewImpl

class RacingController(
    private val view: ResultView = ResultViewImpl(),
    private val rule: RacingRule = RacingRuleImpl(),
) {
    private val cars = mutableListOf<Car>()

    fun start() {
        val input = view.input()
        if (!validateInput(input)) {
            return
        }
        // validation 을 했기 때문에 non-null 임을 보장할 수 있음
        val setting = getGameSetting(input.names!!, input.turnCount!!)

        initialize(setting.names)
        play(setting.turnCount)
        endGame()
    }

    private fun validateInput(input: InputResult): Boolean {
        try {
            InputValidator.carNameInputValidate(input.names)
            InputValidator.turnCountValidate(input.turnCount)
        } catch (e: IllegalArgumentException) {
            view.printMessage(e.message ?: "입력 값이 잘못되었습니다")
            view.printMessage("프로그램을 종료합니다")
            return false
        }
        return true
    }

    private fun getGameSetting(names: String, turnCount: String): GameSetting {
        return GameSetting(InputParser.parseCarNames(names), turnCount.toInt())
    }

    private fun initialize(names: List<String>) {
        for (name in names) {
            cars.add(Car(name, rule))
        }
    }

    private fun play(turnCount: Int) {
        for (turn in 1..turnCount) {
            playTurn()
            view.printTurn(turn, cars)
        }
    }

    private fun playTurn() {
        cars.forEach { car ->
            car.move()
        }
    }

    private fun endGame() {
        val winners = rule.getWinners(cars)
        view.printResult(winners.joinToString())
    }
}
