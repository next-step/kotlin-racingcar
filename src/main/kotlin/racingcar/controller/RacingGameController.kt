package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.TryNumber
import racingcar.domain.generateRandomCondition
import racingcar.view.inputCarNumber
import racingcar.view.inputTryNumber
import racingcar.view.printPlayResult

class RacingGameController {
    fun handle() {
        val racingGame = RacingGame(
            cars = createCars(inputCarNumber()),
            tryNumber = TryNumber(inputTryNumber()),
        )

        printPlayResult(
            racingGame.play(generateRandomCondition())
        )
    }

    private fun createCars(carNumber: Int): Cars {
        val cars = mutableListOf<Car>()
        repeat(carNumber) {
            cars.add(Car())
        }

        return Cars(cars.toList())
    }
}
