package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.printer.ResultPrinter
import racingcar.domain.result.RacingResult
import racingcar.domain.rule.CarRandomMovementRule
import racingcar.view.InputView
import racingcar.view.ResultView
import racingcar.domain.winner.WinnerChecker
import racingcar.domain.turn.TurnManager

fun main() {
    RacingController(InputView(), ResultView()).start()
}

class RacingController(
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun start() {
        val cars = inputView.askHowManyCars()
        val turns = inputView.askHowManyTurns()
        startRacing(cars, turns)
    }

    fun startRacing(cars: List<Car>, turns: Int) {
        val rule = CarRandomMovementRule()
        val turnManager = TurnManager(turns, cars, rule)
        val results = turnManager.startRaceUntilFinish()
        showResult(results)
    }

    fun showResult(results: List<RacingResult>) {
        val racingResult = ResultPrinter().resultToString(results)
        val winnerResult = WinnerChecker().winnerToString(results)
        resultView.showResult(racingResult, winnerResult)
    }
}
