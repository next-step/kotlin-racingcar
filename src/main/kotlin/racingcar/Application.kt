package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingCarForwardCondition
import racingcar.model.RacingCarGame
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val condition = RacingCarForwardCondition { (0..9).random() >= 4 }
    val inputView: InputView = ConsoleInputView()
    val outputView: OutputView = ConsoleOutputView("\uD83D\uDE97")
    val carNames = inputView.getCarNames()
    val cars = carNames
        .map { carName -> Car(carName = carName, condition = condition) }
        .let(::Cars)

    val racingCarGame = RacingCarGame(
        gameCount = inputView.getGameCount(),
        cars = cars
    )
    val result = racingCarGame.startGame()
    outputView.showGameResult(result)
}
