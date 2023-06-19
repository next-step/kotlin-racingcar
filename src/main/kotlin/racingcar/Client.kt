package racingcar

import racingcar.domain.car.CarList
import racingcar.domain.car.carengine.RandomCarEngine
import racingcar.domain.racing.RacingCondition
import racingcar.domain.racing.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val tryCount = InputView.inputTryCount()
    val carList = CarList.of(InputView.inputCarNames())
    val racingCondition = RacingCondition(tryCount, RandomCarEngine)
    val racingGame = RacingGame(carList, racingCondition)

    racingGame.start()
    ResultView.outputResult(racingGame)
}
