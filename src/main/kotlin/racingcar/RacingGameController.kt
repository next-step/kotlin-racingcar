package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingGame
import racingcar.model.RandomValueMovingStrategy
import racingcar.view.Input
import racingcar.view.Output

class RacingGameController(
    private val input: Input,
    private val output: Output
) {

    fun start() {
        val carFactory = CarFactory { carNames ->
            carNames
                .map { carName ->
                    Car(
                        name = carName,
                        movingStrategy = RandomValueMovingStrategy()
                    )
                }
                .let(::Cars)
        }

        val carNames = input.getCarNames()
        val cars = carFactory.createCars(carNames)
        val tryNumber = input.getTryNumber()

        output.showStartMessage()
        val racingGame = RacingGame(tryNumber = tryNumber, cars = cars)
        val result = racingGame.startGame()
        output.printWinners(result)
    }
}
