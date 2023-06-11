package study.racinggame.ui

import study.racinggame.domain.Car

interface RacingGamePrinter {
    fun print(cars: List<Car>)
}
object CommandLineRacingGamePrinter : RacingGamePrinter {
    override fun print(cars: List<Car>) {
        cars.forEach { it.printPosition(HyphenCarPositionPrinter) }
        println()
    }
}
