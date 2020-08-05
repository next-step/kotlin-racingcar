package racingCar

fun main() {
    val amountOfPlayer = InputView.inputAmountOfPlayer()
    val amountOfRound = InputView.inputAmountOfRound()
    val cars = Cars(amountOfPlayer)

    OutputView.showResultMessage()

    repeat(amountOfRound) {
        RacingGame.playGame(cars)
        OutputView.showResult(cars)
    }
}
