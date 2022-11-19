package racingCar.dto

import racingCar.domain.CarName
import racingCar.domain.Cars
import racingCar.domain.Position

class ResultDto(cars: Cars) {

    val positions: Map<CarName, Position> = cars.cars.associate { it.name to it.position }
}
