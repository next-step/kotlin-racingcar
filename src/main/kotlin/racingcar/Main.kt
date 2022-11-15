package racingcar

fun main() {
    val racingCarGame = InputView.receiveInput()
    val gameSnapShots = racingCarGame.startGame()
    ResultView(gameSnapShots).prettyPrint()
}
