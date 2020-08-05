package racingCar

fun main() {
    val amountOfPlayer = InputView.inputAmountOfPlayer()
    val amountOfRound = InputView.inputAmountOfRound()
    val cars = Cars(amountOfPlayer)

    OutputView.showResultMessage()

    for (round in 0 until amountOfRound) {
        RacingGame.playGame(cars)
        OutputView.showResult(cars)
    }
}
