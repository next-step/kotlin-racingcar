package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.CarRandomMovementRule
import racingcar.domain.RacingResult
import racingcar.domain.ResultPrinter
import racingcar.domain.TurnManager
import racingcar.domain.WinnerChecker
import racingcar.view.InputView
import racingcar.view.ResultView

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
        val winnerResult = WinnerChecker().findWinners(results.last().cars)
        resultView.showResult(racingResult, winnerResult)
    }
}
