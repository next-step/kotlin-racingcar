package study.racinggame.domain

import study.racinggame.ui.CarPositionPrinter

class Car(private val engine: CarEngine) {
    private var position: Int = 1

    fun move(): Int {
        position += engine.run()
        return position
    }

    fun printPosition(printer: CarPositionPrinter) {
        printer.print(position)
    }
}
