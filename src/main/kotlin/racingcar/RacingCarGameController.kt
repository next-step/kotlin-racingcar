package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingCarForwardCondition
import racingcar.model.RacingCarGame
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarGameController {

    private val inputView: InputView = ConsoleInputView()
    private val outputView: OutputView = ConsoleOutputView()

    private val randomForwardCondition = RacingCarForwardCondition {
        (0..9).random() >= 4
    }

    fun start() {
        val carNames = inputView.getCarNames()
        val cars = carNames
            .map { carName -> Car(carName = carName, condition = randomForwardCondition) }
            .let(::Cars)

        val racingCarGame = RacingCarGame(
            gameCount = inputView.getGameCount(),
            cars = cars
        )
        val result = racingCarGame.startGame()
        outputView.showGameResult(result)
    }
}
