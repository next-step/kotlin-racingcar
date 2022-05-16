package racingcar.race

import racingcar.car.Car

class Race(carCount: Int, val moveCount: Int) {
    val cars = List(carCount) { Car(it + 1, moveCount) }
}
