package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.TryNumber
import racingcar.domain.generateRandomCondition
import racingcar.view.inputCarNames
import racingcar.view.inputTryNumber
import racingcar.view.printPlayResult

class RacingGameController {
    fun handle() {
        val racingGame = RacingGame(
            cars = createCars(inputCarNames()),
            tryNumber = TryNumber(inputTryNumber()),
        )

        printPlayResult(
            racingGame.play(generateRandomCondition())
        )
    }

    private fun createCars(carNames: List<String>): Cars {
        val cars = carNames.map { Car(it) }
        return Cars(cars)
    }
}
