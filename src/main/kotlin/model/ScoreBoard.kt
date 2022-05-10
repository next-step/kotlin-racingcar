package model

import port.OutputPainter

class ScoreBoard(private val painter: OutputPainter, private val cars: List<Car>) {

    fun draw() = cars.map(Car::toString).forEach(painter::draw)
}
