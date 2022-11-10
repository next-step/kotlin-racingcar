package step3.controller

import step3.domain.DefaultRandomGenerator
import step3.domain.RacingGame
import step3.model.Car
import step3.model.DefaultCar
import step3.ui.InputView
import step3.ui.ResultView

fun main() {
    val (carNum, executeNum) = InputView.requestCarNum() to InputView.requestExecuteNum()
    val cars = List<Car>(carNum) { DefaultCar() }
    val racingGame = RacingGame(DefaultRandomGenerator(), cars)

    ResultView.printIntro()
    repeat(executeNum) {
        racingGame.race()
        ResultView.printResult(racingGame.cars)
    }
}
