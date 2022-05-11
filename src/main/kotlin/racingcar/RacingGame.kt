package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.TryNumber
import racingcar.view.Input
import racingcar.view.Output

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
    val racingGame = RacingGame(
        input = Input(),
        output = Output(),
        carFactory = CarFactory { carCount ->
            Cars(List(carCount.count) { Car(id = it) })
        }
    )
}

