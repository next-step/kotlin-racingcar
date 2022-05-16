package racinggame.controller

import racinggame.domain.RacingGame
import racinggame.domain.car.CarFactory
import racinggame.view.RacingGameLayout

class RacingGameController(private val racingGameLayout: RacingGameLayout) {
    fun execute(carFactory: CarFactory) {
        val racingGameInput = racingGameLayout.receiveUserInput()
        val racingGame = RacingGame.of(
            racingGameInput,
            carFactory
        )
        racingGameLayout.showResult(racingGame.start())
    }
}
