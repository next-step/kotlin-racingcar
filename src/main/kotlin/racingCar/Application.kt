package racingCar

fun main() {
    val players = InputView.inputCarNames().split(",")
    val amountOfRound = InputView.inputAmountOfRound()
    val cars = Cars(players)

    OutputView.showResultMessage()

    repeat(amountOfRound) {
        RacingGame.playGame(cars)
        OutputView.showResult(cars)
    }

    val winner = cars.findWinners()
    OutputView.showWinners(winner)
}
