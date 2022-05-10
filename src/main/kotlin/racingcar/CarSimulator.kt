package racingcar


fun main() {
    val inputView = InputView()
    val carNames = inputView.getCarNamesInput(RacingCarGame.CAR_NAMES_INPUT_DESC)
    val trialCount =  inputView.getNaturalNumberInput(RacingCarGame.TRIAL_NUMBER_INPUT_DESC)

    val racingCarGame = RacingCarGame(trialCount, carNames)
    racingCarGame.play()

    val gameResult = racingCarGame.gameResults

    val resultView = ResultView()
    resultView.printGameResult(gameResult)
}