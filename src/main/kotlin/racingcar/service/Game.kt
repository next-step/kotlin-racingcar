package racingcar.service

import racingcar.entity.Car

class Game(carCount: Int, raceCount: Int) {
    val cars = List(carCount) { Car() }

}

fun getRandomMoveCount(): Int {
    val range = (0..9)
    return range.random()
}