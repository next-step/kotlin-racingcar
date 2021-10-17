package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingCarForwardCondition
import racingcar.model.RacingCarGame
import racingcar.model.RacingCarsFactory
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingCarForwardCondition = RacingCarForwardCondition { (0..9).random() >= 4 }
    val racingCarsFactory = RacingCarsFactory { carNames ->
        carNames.map { carName ->
            Car(
                carName = carName,
                condition = racingCarForwardCondition
            )
        }.let(::Cars)
    }
    val inputView: InputView = ConsoleInputView()
    val outputView: OutputView = ConsoleOutputView()
    val carNames = inputView.getCarNames()
    val racingCarGame = RacingCarGame(
        gameCount = inputView.getGameCount(),
        cars = racingCarsFactory.createCars(carNames)
    )
    racingCarGame.startGame()
}
