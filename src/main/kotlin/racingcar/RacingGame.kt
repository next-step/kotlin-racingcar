package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RandomValueMovingStrategy
import racingcar.model.TryNumber
import racingcar.view.Input
import racingcar.view.Output
import kotlin.random.Random

class RacingGame(
    val input: Input,
    val output: Output,
    val carFactory: CarFactory
) {

    private fun race(cars: Cars): Cars {
        return cars.moveForwardCars()
    }

    fun startGame() {
        val carNames = input.getCarNames()
        val cars = carFactory.createCars(carNames)
        val tryNumber = input.getTryNumber()

        output.showStartMessage()
        val finishedCars = startGame(cars, tryNumber)
        output.printWinners(finishedCars)
    }

    private tailrec fun startGame(cars: Cars, tryNumber: TryNumber): Cars {
        if (tryNumber.number == 0) {
            return cars
        }

        val movedCars = race(cars)
        output.showResultPosition(movedCars)

        return startGame(movedCars, tryNumber.minus())
    }
}

fun main() {
    val movingStrategy = { RandomValueMovingStrategy(Random.nextInt(Car.MAX_BOUND)).forwardMovable() }
    val racingGame = RacingGame(
        input = Input(),
        output = Output(),
        carFactory = { carNames ->
            Cars(List(carNames.size) { Car(name = carNames[it], movingStrategy = movingStrategy) })
        }
    )
    racingGame.startGame()
}
