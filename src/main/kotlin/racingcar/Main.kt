package racingcar

fun main() {
    val racingGame = RacingGame()

    val (numberOfCars, count) = InputView.view()
    racingGame.set(numberOfCars, count)

    for (i in 1..count) {
        racingGame.run()
        ResultView.view(racingGame.carList)
    }
}
