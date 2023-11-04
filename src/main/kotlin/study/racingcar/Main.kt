package study.racingcar

fun main() {
    val inputView = InputView(DefaultInputProvider())
    val carNames = inputView.getCarNames()
    val numberOfRounds = inputView.getNumberOfRounds()

    val race = Race(carNames, numberOfRounds)
    val resultView = ResultView(DefaultOutputReceiver())

    resultView.startDisplayResult()
    race.run { cars ->
        resultView.displayRound(cars)
    }
    resultView.displayWinners(race.getWinners())
}
