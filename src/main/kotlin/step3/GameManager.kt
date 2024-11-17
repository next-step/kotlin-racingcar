package step3

import step3.UserInputType.ATTEMPT_COUNT
import step3.UserInputType.NUMBER_OF_CARS
import step3.ui.InputView
import step3.ui.ResultView

class GameManager {
    lateinit var inputView: InputView
    lateinit var resultView: ResultView
    lateinit var randomNumberGenerator: RandomNumberGenerator

    fun start() {
        val numberOfCar = getNumberOfCars()
        val racingCars = createRacingCars(numberOfCar)

        val attemptCount = getAttemptCount()

        repeat(attemptCount) {
            val carStatus = playRound(racingCars)
            printRaceResults(carStatus)
        }
    }

    fun getNumberOfCars(): Int {
        return inputView.readUserInput(NUMBER_OF_CARS)
    }

    fun getAttemptCount(): Int {
        return inputView.readUserInput(ATTEMPT_COUNT)
    }

    fun createRacingCars(numberOfCar: Int): List<Car> {
        return List(numberOfCar) { Car(id = it + 1) }
    }

    fun playRound(racingCars: List<Car>): List<Car> {
        return racingCars.map { car ->
            val randomNumber = randomNumberGenerator.generate()
            processCarMovement(car, randomNumber)
        }
    }

    fun processCarMovement(
        car: Car,
        randomNumber: Int,
    ): Car {
        if (isMovable(randomNumber)) {
            return moveForward(car)
        }
        return car
    }

    fun isMovable(randomNumber: Int): Boolean = randomNumber >= 4

    fun moveForward(car: Car) = car.copy(id = car.id, position = car.position + 1)

    fun printRaceResults(racingCars: List<Car>) = resultView.printCurrentPosition(racingCars)
}
