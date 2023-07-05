package racingcar

import racingcar.controller.RacingGame
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.InputView

fun main() {
    val carNames = InputView().inputCarNames()
    val tryNum = InputView().inputTryNum()

    val racingGame = RacingGame(Cars(carNames.map { Car(it) }))
    println("\n실행 결과")
    racingGame.start(tryNum)
}
