package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Car.Companion.move
import racingcar.view.InputView
import racingcar.view.ResultView

class Application {

    fun main() {
        val numberOfCars = InputView.registerParticipant()
        val times = InputView.setNumberOfTimes()

        ResultView.executionResult()

        val cars = Car.registerCars(numberOfCars)

        (1..times).forEach { _ ->
            cars.map { it.move() }
                .forEach { ResultView.presentSituation(it) }
            println()
        }
    }
}
