package study.racinggame.domain

import study.racinggame.ui.RacingGamePrinter

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
