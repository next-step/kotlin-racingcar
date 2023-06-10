package study.step3.ui

import study.step3.domain.Car

interface RacingGamePrinter {
    fun print(cars: List<Car>)
}
object CommandLineRacingGamePrinter : RacingGamePrinter {
    override fun print(cars: List<Car>) {
        cars.forEach { it.printPosition(HyphenCarPositionPrinter) }
        println()
    }
}
