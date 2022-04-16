package racingcar

import racingcar.domain.racing.CarsHistory
import racingcar.domain.racing.RacingCarGame
import racingcar.domain.racing.Winners
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carNames = inputView.carNames()
    val attemptCount = inputView.attemptCount()
    val game = RacingCarGame(
        carNames = carNames,
        attemptCount = attemptCount
    )
    val carsHistory: CarsHistory = game.play()
    val winners = Winners(carsHistory)
    ResultView().printResult(carsHistory = carsHistory, winners = winners)
}
