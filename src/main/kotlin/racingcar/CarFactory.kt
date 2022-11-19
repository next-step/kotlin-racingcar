package racingcar

import racingcar.dto.CarCreateDto

object CarFactory {
    fun createMany(dtos: List<CarCreateDto>): List<Car> {
        return dtos.mapIndexed { index, dto ->
            Car(id = index, name = dto.name)
        }
    }
}
