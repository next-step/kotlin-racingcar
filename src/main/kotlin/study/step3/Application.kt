package study.step3

import study.step3.io.InputView

fun main() {
    val carCount = InputView.getCountOfCars()
    val attempts = InputView.getCountOfAttempts()

    val racingGame = RacingGame(carCount, attempts)
    racingGame.run()
}
