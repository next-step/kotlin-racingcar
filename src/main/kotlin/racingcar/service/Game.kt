package racingcar.service

import racingcar.entity.Car

class Game(carCount: Int, val raceCount: Int) {
    private val cars = List(carCount) { Car() }

    fun start() {
        repeat(raceCount) {
            cars.forEach { e -> e.move(getRandomMoveCount()) }
        }
    }

    fun result() {
        cars.forEach { e ->
            println(e.getResult())
        }
    }
}

fun getRandomMoveCount(): Int {
    val range = (0..9)
    return range.random()
}
