package racingcar

import racingcar.domain.car.CarList
import racingcar.domain.racing.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val racingInputData = InputView.inputRacingData()
    val carList = CarList.of(racingInputData.carNames)
    val racingGame = RacingGame(carList, racingInputData.racingCondition)

    racingGame.start()
    ResultView.outputResult(racingGame)
}
