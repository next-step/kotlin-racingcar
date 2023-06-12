package racingcar

import racingcar.domain.car.CarList
import racingcar.domain.racing.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val racingCondition = InputView.inputRacingCondition()
    val carList = CarList.of(racingCondition.carCount)
    val racingGame = RacingGame(carList, racingCondition)

    val racingRecord = racingGame.start()
    ResultView.outputResult(racingRecord)
}
