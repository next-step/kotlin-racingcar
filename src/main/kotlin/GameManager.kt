import UserInputType.ATTEMPT_COUNT
import UserInputType.NUMBER_OF_CARS
import ui.InputView
import ui.ResultView

class GameManager {
    lateinit var inputView: InputView
    lateinit var resultView: ResultView
    lateinit var randomNumberGenerator: RandomNumberGenerator

    fun start() {
        val numberOfCar = getNumberOfCars()
        val racingCars = createRacingCars(numberOfCar)

        val attemptCount = getAttemptCount()

        repeat(attemptCount) {
            playRound(racingCars)
            printRaceResults(racingCars)
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

    fun playRound(racingCars: List<Car>) {
        racingCars.forEach { car ->
            val randomNumber = randomNumberGenerator.generate()
            processCarMovement(car, randomNumber)
        }
    }

    fun processCarMovement(
        car: Car,
        randomNumber: Int,
    ) {
        if (isMovable(randomNumber)) {
            moveForward(car)
        }
    }

    fun isMovable(randomNumber: Int): Boolean = randomNumber >= 4

    fun moveForward(car: Car) = car.run { forward() }

    fun printRaceResults(racingCars: List<Car>) = resultView.printCurrentPosition(racingCars)
}
