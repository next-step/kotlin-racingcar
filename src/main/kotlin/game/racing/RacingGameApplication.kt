package game.racing

import game.racing.domain.CarFactory
import game.racing.domain.RacingGame
import game.racing.domain.RacingManager
import game.racing.view.InputView

fun main() {
    val cars = CarFactory.generateCarByCarNames(InputView.inputCarNames().split(InputView.CAR_NAME_DELIMITER))
    val racingGame = RacingGame(RacingManager(cars), InputView.inputTryNumber())
    racingGame.start()
}
