package step3

import step3.UserInputType.ATTEMPT_COUNT
import step3.ui.InputView
import step3.ui.ResultView

class GameManager(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val randomNumberGenerator: RandomNumberGenerator,
) {
    fun start() {
        val numberOfCar = inputView.getNumberOfCars()
        val racingCars = createRacingCars(numberOfCar)
        val attemptCount = inputView.readUserInput(ATTEMPT_COUNT)

        repeat(attemptCount) {
            playRound(racingCars) // 자동차 상태를 업데이트
            resultView.printRaceResults(racingCars) // 필요시 결과 출력
        }
    }

    fun createRacingCars(numberOfCar: Int): MutableList<Car> {
        return MutableList(numberOfCar) { Car(id = it + 1) }
    }

    fun playRound(racingCars: MutableList<Car>) {
        racingCars.forEachIndexed { index, car ->
            val randomNumber = randomNumberGenerator.generate()
            if (isMovable(randomNumber)) {
                racingCars[index] = moveForward(car)
            }
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
}
