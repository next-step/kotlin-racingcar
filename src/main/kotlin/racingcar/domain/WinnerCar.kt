package racingcar.domain

import racingcar.dto.CarDto
import racingcar.dto.CarsDto

object WinnerCar {
    fun from(racingCars: CarsDto): List<CarDto> {
        return racingCars.contentsFilter { it -> it.position == racingCars.maxOfPositions() }
    }
}
