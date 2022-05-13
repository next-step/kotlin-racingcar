package model

import port.OutputPainter

class ScoreBoard(private val painter: OutputPainter) {

    fun draw(cars: List<Car>) =
        cars.map(Car::toString).forEach {
            painter.draw("${it}\n")
        }
}
