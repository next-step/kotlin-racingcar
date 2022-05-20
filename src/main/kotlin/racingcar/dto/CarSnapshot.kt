package racingcar.dto

import racingcar.domain.Car

class CarSnapshot(car: Car) {
    val position = car.position.value
}
