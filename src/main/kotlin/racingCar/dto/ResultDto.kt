package racingCar.dto

import racingCar.domain.Cars
import racingCar.domain.Position

class ResultDto(cars: Cars) {

    val positions: List<Position> = cars.cars.map { it.position }
}
