package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RandomValueMovingStrategy
import racingcar.view.Input
import racingcar.view.Output

fun main() {
    val movingStrategy = { RandomValueMovingStrategy((0..9).random()).forwardMovable() }

    val racingGameController = RacingGameController(
        input = Input(),
        output = Output(),
        carFactory = { carNames ->
            carNames
                .map { carName -> Car(name = carName, movingStrategy = movingStrategy) }
                .let(::Cars)
        }
    )

    racingGameController.start()
}
