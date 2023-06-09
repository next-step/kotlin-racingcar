package racinggame.view

fun startRacingGameScreen() {
    RacingGameController(
        inputView = RealRacingGameInputView(),
        outputView = RealRacingGameOutputView(),
    ).start()
}
