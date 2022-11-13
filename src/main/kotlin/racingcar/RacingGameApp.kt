package racingcar

import racingcar.domain.DefaultRandomGenerator
import racingcar.domain.RacingGame
import racingcar.model.Car
import racingcar.model.DefaultCar
import racingcar.ui.InputView
import racingcar.ui.ResultView

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
