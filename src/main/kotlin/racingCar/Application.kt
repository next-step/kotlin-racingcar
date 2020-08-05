package racingCar

fun main() {
    val amountOfPlayer = InputView.inputAmountOfPlayer()
    val amountOfRound = InputView.inputAmountOfRound()
    val cars = Cars(amountOfPlayer)

    RacingGame.playGame(amountOfRound, cars)
}
