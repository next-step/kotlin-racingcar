package src.step3

object RacingCarGame {
    fun startGame() {
        val inputValue = InputView.executeInputScreen()
        ResultView.showGameResult(inputValue.carNumber, inputValue.tryCount)
    }
}

fun main() {
    RacingCarGame.startGame()
}
