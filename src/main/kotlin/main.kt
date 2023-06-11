import racing.game.RacingGame
import racing.view.InputView

fun main() {
    // step2
    // val scanner = Scanner(System.`in`)
    // val calculator = Calculator(scanner.nextLine())
    // println("result = " + calculator.calculate())

    // step3
    val input = InputView()
    val carCount = input.inputCarCount()
    val retryCount = input.inputRetryCount()

    val racingGame = RacingGame()
    val racingCars = racingGame.racingGameCarInit(carCount)
    racingGame.executeGame(retryCount, racingCars)
}
