package racinggame.view

import racinggame.domain.car.factory.RealRacingCarFactory
import racinggame.domain.game.RealRacingGame

fun startRacingGameScreen() {
    RacingGameController(
        inputView = RealRacingGameInputView(),
        outputView = RealRacingGameOutputView(),
        racingGame = RealRacingGame(
            racingCarFactory = RealRacingCarFactory(),
        ),
    ).start()
}
