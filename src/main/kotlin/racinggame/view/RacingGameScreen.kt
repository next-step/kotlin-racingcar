package racinggame.view

import racinggame.domain.RealRacingGame

fun startRacingGameScreen() {
    RacingGameController(
        inputView = RealRacingGameInputView(),
        outputView = RealRacingGameOutputView(),
        racingGame = RealRacingGame(),
    ).start()
}
