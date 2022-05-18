package main

import car.domain.CarRacing
import car.view.InputView
import car.view.ResultView

/**
 * 자동차 경주 게임 시작(Main)
 *
 * ex)
 * 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
 * 콩나물비빔밥,에버랜드,여수
 * 시도할 횟수는 몇 회인가요?
 * 3
 * 실행 결과:
 * 콩나물비빔 :
 * 에버랜드 : -
 * 여수 : -
 *
 * 콩나물비빔 : -
 * 에버랜드 : --
 * 여수 : -
 *
 * 콩나물비빔 : --
 * 에버랜드 : --
 * 여수 : -
 *
 * 콩나물비빔, 에버랜드가 최종 우승했습니다.
 */
fun main() {
    val inputView = InputView(reader = ::readLine, console = ::print)
    val driverNames = inputView.readDriverNames()
    val moves = inputView.readMoves()

    val game = CarRacing.newGame(driverNames = driverNames, moves = moves)
    val records = game.play()

    val resultView = ResultView(console = ::print)
    resultView.showRecords(gameRecords = records)
}
