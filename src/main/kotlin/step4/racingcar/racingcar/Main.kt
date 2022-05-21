package step4.racingcar.racingcar

fun main() {

    val racers = InputView.racers()
    val movementCount = InputView.movementCount()

    val racingGame = CarRacing(racers, movementCount)
    racingGame.execute(RandomNumber)
    ResultView.view(racingGame)
}
