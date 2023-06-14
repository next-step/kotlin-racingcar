package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

object OutputView {
    fun printRequestCarCount() {
        println(Messages.MESSAGE_REQUEST_CAR_NAME)
    }

    fun printRequestAttemptCount() {
        println(Messages.MESSAGE_REQUEST_ATTEMPT_COUNT)
    }

    fun printExecutionResult() {
        println(Messages.MESSAGE_EXECUTION_RESULT)
    }

    fun printCarNameAndPosition(cars: Cars) {
        cars.getCars().stream().forEach { car ->
            print("${car.carName.name} : ")
            println("-".repeat(car.position))
        }
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString { it.carName.name }
        println("${winnerNames}이(가) 최종 우승했습니다.")
    }

    fun print() {
        println()
    }
}
