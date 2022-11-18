package racingCar.dto

import racingCar.domain.Cars
import racingCar.domain.Position
import racingCar.domain.CarName

class ResultDto(cars: Cars) {

    val positions: Map<CarName, Position> = cars.cars
        .map { it.key to it.value.position }
        .toMap()
}
