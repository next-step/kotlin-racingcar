package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.RandomCondition
import racingcar.view.OutputConsoleView

class RacingCarService(private val outputView: OutputConsoleView) {
    fun play(names: List<String>, attempts: Int): List<String> {
        val cars = Cars(names, RandomCondition())

        repeat(attempts) {
            cars.attempt()
            outputView.printCarsPosition(cars)
        }
        return cars.getWinners()
    }
}
