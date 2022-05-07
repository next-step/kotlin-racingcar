package racingcar


fun main() {
    val inputView = InputView()
    val carCount = inputView.getNaturalNumberInput("자동차 대수는 몇 대인가요?")
    val trialCount =  inputView.getNaturalNumberInput("시도할 횟수는 몇 회인가요?")

    val racingCarGame = RacingCarGame(carCount, trialCount)
    racingCarGame.prepare()
    racingCarGame.play()

    val gameResult = racingCarGame.gameResult

    val resultView = ResultView()
    resultView.printGameResult(gameResult)
}