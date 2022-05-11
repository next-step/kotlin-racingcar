package racingcar

fun main() {
    val inputView = InputView()
    val carNames = inputView.getCarNamesInput(RacingCarGame.CAR_NAMES_INPUT_DESC)
    val trialCount = inputView.getNaturalNumberInput(RacingCarGame.TRIAL_NUMBER_INPUT_DESC)

    val seedMaker = SeedMakerImpl()
    val racingCarGame = RacingCarGame(trialCount, seedMaker, carNames)
    racingCarGame.play()

    val gameResult = racingCarGame.gameResults

    val resultView = ResultView()
    resultView.printGameHistory(gameResult)
    resultView.printWinnerResult(racingCarGame.getWinnerResult())
}
