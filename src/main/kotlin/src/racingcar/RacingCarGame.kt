package src.racingcar

object RacingCarGame {
    fun startGame() {
        val inputValue = InputView.executeInputScreen()
        val raceCars = CarService(getCarMoveRandomValue()).execute(inputValue.carNames)
        ResultView.printRacingCarGameResult(inputValue.tryCount, raceCars)
    }
}

fun main() {
    RacingCarGame.startGame()
}
