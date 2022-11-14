package src.racingcar

object RacingCarGame {
    fun startGame() {
        val inputValue = InputView.executeInputScreen()
        val cars = CarOperator
            .calculateCarMoveDistance(inputValue.carNumber, inputValue.tryCount)
        ResultView.showGameResult(cars)
    }
}

fun main() {
    RacingCarGame.startGame()
}
