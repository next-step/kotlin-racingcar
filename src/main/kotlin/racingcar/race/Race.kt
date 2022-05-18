package racingcar.race

import racingcar.car.Car
import racingcar.count.CarCount
import racingcar.count.MoveCount

class Race(carCount: CarCount, moveCount: MoveCount) {
    val railSize = moveCount.value
    val cars = List(carCount.value) { Car(railSize) }
}
