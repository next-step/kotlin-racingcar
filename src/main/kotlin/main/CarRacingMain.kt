package main

import car.racing.CarRacing
import car.racing.InputView
import car.racing.ResultView

/**
 * 3단계 자동차 경주 게임 시작(Main)
 *
 * ex)
 * 자동차 대수는 몇 대인가요?
 * 3
 * 시도할 횟수는 몇 회인가요?
 * 5
 *
 * 실행 결과
 * ...
 */
fun main() {
    val inputView = InputView(reader = ::readLine, console = ::print)
    val driverNames = inputView.readDriverNames()
    val moves = inputView.readMoves()

    val game = CarRacing.newGame(driverNames = driverNames, moves = moves)
    val records = game.play()

    val resultView = ResultView(::print)
    resultView.showRecords(records)
}
