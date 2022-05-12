package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.TryNumber
import racingcar.view.inputCarNumber
import racingcar.view.inputTryNumber

class RacingGameController {
    fun handle() {
        val racingGame = RacingGame(
            cars = createCars(inputCarNumber()),
            tryNumber = TryNumber(inputTryNumber()),
        )

        // val playResult = racingGame.play()
    }

    private fun createCars(carNumber: Int): List<Car> {
        val cars = mutableListOf<Car>()
        repeat(carNumber) {
            cars.add(Car())
        }

        return cars.toList()
    }
}
