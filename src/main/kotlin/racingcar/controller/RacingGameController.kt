package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.TryNumber
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.generateRandomCondition
import racingcar.view.inputCarNames
import racingcar.view.inputTryNumber
import racingcar.view.printPlayResult
import racingcar.view.printWinners

class RacingGameController {
    fun handle() {
        val racingGame = RacingGame(
            cars = createCars(inputCarNames()),
            tryNumber = TryNumber(inputTryNumber()),
        )

        racingGame.play(generateRandomCondition())
            .also {
                printPlayResult(it)
            }
        printWinners(racingGame.getWinners())
    }

    private fun createCars(carNames: List<String>): Cars {
        val cars = carNames.map { Car(it) }
        return Cars(cars)
    }
}
