package racingcar.service

import racingcar.domain.Cars
import racingcar.domain.RandomCondition
import racingcar.view.OutputView

class RacingCarService {
    private val outputView = OutputView()

    fun play(names: List<String>, attempts: Int): List<String> {
        val cars = Cars(names)

        repeat(attempts) {
            cars.attempt(RandomCondition())
            outputView.printCarsPosition(cars)
        }
        return cars.getWinners()
    }
}
