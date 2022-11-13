package racingCar.dto

import racingCar.domain.Cars
import racingCar.domain.Position
import racingCar.domain.Username

class ResultDto(cars: Cars) {

    val positions: Map<Username, Position> = cars.cars
        .map { it.key to it.value.position }
        .toMap()
}
