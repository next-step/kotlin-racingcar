package racingcar.racing.controller

import racingcar.racing.car.Car
import racingcar.racing.printer.ResultPrinter
import racingcar.racing.result.RacingResult
import racingcar.racing.rule.CarRandomMovementRule
import racingcar.racing.view.InputView
import racingcar.racing.view.ResultView
import racingcar.racing.winner.WinnerChecker
import racingcar.turn.TurnManager

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
        // 게임 시작
        startRacing(cars, turns)
    }

    fun startRacing(cars: List<Car>, turns: Int) { //
        val rule = CarRandomMovementRule()
        val turnManager = TurnManager(turns, cars, rule)
        // 레이싱 시작
        val results = turnManager.startRaceUntilFinish()
        // 결과 출력
        showResult(results)
    }

    fun showResult(results: List<RacingResult>) {
        val racingResult = ResultPrinter().resultToString(results)
        val winnerResult = WinnerChecker().winnerToString(results)
        resultView.showResult(racingResult, winnerResult)
    }
}
