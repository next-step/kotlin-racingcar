package study.step3.ui

import study.step3.domain.Car

interface RacingGamePrinter {
    fun print(cars: List<Car>)
}
class CommandLineRacingGamePrinter : RacingGamePrinter {
    override fun print(cars: List<Car>) {
        cars.forEach {
            (0 until it.position).forEach { position -> print('-') }
            println()
        }
        println()
    }
}
