package racingCar.dto

import racingCar.domain.Cars
import racingCar.domain.Position
import java.util.stream.Collectors

class ResultDto(cars: Cars) {

    val positions: List<Position> = cars.cars.stream()
        .map { it.position }
        .collect(Collectors.toList())
}
