package racingcar

fun main() {
    val racingCarGame = InputView.receiveInput()
    val gameSnapShots = racingCarGame.startGame()
    ResultWithNameView.prettyPrint(gameSnapShots)
}
