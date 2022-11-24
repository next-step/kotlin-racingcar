package racingcar.dto

import racingcar.domain.CarName
import racingcar.domain.Cars
import racingcar.domain.Position

class ResultDto(cars: Cars) {

    val positions: Map<CarName, Position> = cars.cars.associate { it.name to it.position }
}
