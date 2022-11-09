package racingcar.application

import racingcar.RandomGear
import racingcar.domain.Car
import racingcar.domain.Car.Companion.drive
import racingcar.view.InputView
import racingcar.view.ResultView

class Application {

    fun main() {
        InputView.registerParticipant()
        val numberOfCars = InputView.getParticipant()

        InputView.setNumberOfTimes()
        val numberOfTimes = InputView.getNumberOfTimes()

        ResultView.executionResult()

        val cars = Car.registerCars(numberOfCars)

        (1..numberOfTimes).forEach { _ ->
            cars.map { it.move() }
                .forEach { ResultView.presentSituation(it) }
            println()
        }
    }
}
