package src.racingcar

object RacingCarGame {
    fun startGame() {
        val inputValue = InputView.executeInputScreen()
        CarService().execute(inputValue.tryCount, inputValue.carNumber)
    }
}

fun main() {
    RacingCarGame.startGame()
}
