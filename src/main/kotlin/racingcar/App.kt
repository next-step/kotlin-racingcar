package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RandomValueMovingStrategy
import racingcar.view.Input
import racingcar.view.Output

fun main() {

    val racingGameController = RacingGameController(
        input = Input(),
        output = Output(),
        carFactory = { carNames ->
            carNames
                .map { carName ->
                    Car(
                        name = carName,
                        movingStrategy = RandomValueMovingStrategy()
                    )
                }
                .let(::Cars)
        }
    )

    racingGameController.start()
}
