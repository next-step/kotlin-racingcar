package racingcar

import racingcar.domain.Car
import racingcar.domain.CarMoveCondition
import racingcar.domain.RacingGame
import racingcar.domain.RacingGameRecorder
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carsName = InputView.getCarsName()
    val tryMoveCount = InputView.getTryMoveCount()

    val moveCondition = CarMoveCondition {
        (0..10).random()
    }

    val cars = carsName.map { name ->
        Car(moveCondition, name)
    }

    val gameRecorder = RacingGameRecorder()

    RacingGame().play(cars, tryMoveCount, gameRecorder)

    val gameResult = gameRecorder.gameResultRecord

    ResultView.printGameResult(gameResult)
}
