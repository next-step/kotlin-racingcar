package racingcar.application

import racingcar.RandomGear
import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.ResultView

class Application {

    fun main() {
        val register = InputView.register()
        val cars = Car.registerCars(register.participant)

        ResultView.executionResult()
        repeat(register.times) {
            cars.forEach {
                it.drive(RandomGear.getGear())
                ResultView.presentSituation(it.name, it.currentPosition)
            }
            println()
        }

        val winners = Car.getFurthestCars(cars)
        ResultView.getWinner(winners)
    }
}
