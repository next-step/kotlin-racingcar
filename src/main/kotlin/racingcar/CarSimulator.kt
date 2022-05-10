package racingcar


fun main() {
    val inputView = InputView()
    val carCount = inputView.getNaturalNumberInput(RacingCarGame.CAR_NUMBER_INPUT_DESC)
    val trialCount =  inputView.getNaturalNumberInput(RacingCarGame.TRIAL_NUMBER_INPUT_DESC)

    val racingCarGame = RacingCarGame(carCount, trialCount)
    racingCarGame.play()

    val gameResult = racingCarGame.getGameResult()

    val resultView = ResultView()
    resultView.printGameResult(gameResult)
}