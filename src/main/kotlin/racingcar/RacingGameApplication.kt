package racingcar

fun main(args: Array<String>) {
    val carNames = InputView.getCarNames()
    val trials = InputView.getTryChance()

    val racing = RacingGame(carNames, trials)

    racing.start()

    ResultView.showRace(RecordRepository.gameRecords)
    ResultView.notifyWinner(RecordRepository.findWinners())
}
