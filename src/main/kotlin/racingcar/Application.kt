package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

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
    val racingCarGame = RacingCarGame(
        inputView = ConsoleInputView(),
        outputView = ConsoleOutputView("\uD83D\uDE97"),
        racingCarsFactory = racingCarsFactory,
    )
    racingCarGame.startGame()
}
