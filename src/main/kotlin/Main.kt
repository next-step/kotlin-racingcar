import controller.RacingGame
import domain.Winner
import view.InputView
import view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val race = RacingGame.create(inputView.inputCarNames())
    val retryCount = inputView.inputRetryCount()
    repeat(retryCount) {
        race.start()
        resultView.printRacingGame(race.cars)
    }

    resultView.printWinner(Winner(race.cars).getWinner())
}
