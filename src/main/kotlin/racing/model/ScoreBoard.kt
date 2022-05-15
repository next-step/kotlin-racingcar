package racing.model

import racing.port.OutputPainter

class ScoreBoard(private val painter: OutputPainter) {

    fun draw(cars: Cars) {
        painter.draw(cars.toPrintableCars("\n"))
    }
}
