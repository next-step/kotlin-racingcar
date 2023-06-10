package study.step3.domain

import study.step3.ui.RacingGamePrinter

class RacingGame(
    val cars: List<Car>,
    val numberOfTries: Int,
) {

    fun start(racingGamePrinter: RacingGamePrinter) {
        repeat(numberOfTries) {
            cars.forEach { it.move() }
            racingGamePrinter.print(cars)
        }
    }
}
