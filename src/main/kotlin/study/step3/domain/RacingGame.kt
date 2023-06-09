package study.step3.domain

import study.step3.ui.RacingGamePrinter

class RacingGame private constructor (
    val cars: List<Car>,
    val numberOfTries: Int,
) {

    fun start(racingGamePrinter: RacingGamePrinter) {
        repeat(numberOfTries) {
            cars.forEach { it.move() }
            racingGamePrinter.print(cars)
        }
    }

    companion object {
        fun of(racingGameConfiguration: RacingGameConfiguration): RacingGame {
            val cars = (0 until racingGameConfiguration.numberOfCars).map { Car(RandomSeedEngine()) }
            return RacingGame(cars, racingGameConfiguration.numberOfTries)
        }
    }
}
