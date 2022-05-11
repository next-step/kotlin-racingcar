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

    private fun race(cars: Cars) {
        cars.moveForwardCars()
    }

    fun startGame() {
        val carCount = input.getCarCount()
        val tryNumber = input.getTryNumber()

        val cars = carFactory.createCars(carCount)

        startGame(cars, tryNumber)
    }

    private fun startGame(cars: Cars, tryNumber: TryNumber) {
        output.showStartMessage()
        repeat(tryNumber.number) {
            race(cars)
            output.showResultPosition(cars)
        }
    }
}

fun main() {
    val movingStrategy = { RandomValueMovingStrategy(Random.nextInt(Car.MAX_BOUND)).forwardMovable() }
    val racingGame = RacingGame(
        input = Input(),
        output = Output(),
        carFactory = CarFactory { carCount ->
            Cars(List(carCount.count) { Car(id = it, movingStrategy = movingStrategy) })
        }
    )
    racingGame.startGame()
}
