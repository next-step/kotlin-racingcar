package racingcar.service

import racingcar.domain.Cars
import racingcar.dto.CarsDto
import racingcar.view.inputTryCount

class RacingService {
    fun play(racingCars: Cars): List<CarsDto> {
        val snapshots = mutableListOf<CarsDto>()
        repeat(inputTryCount()) {
            racingCars.move()
            snapshots.add(CarsDto(racingCars.toCarDtoList()))
        }
        return snapshots
    }
}
