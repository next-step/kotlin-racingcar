package step3

import step3.dto.CarCreateDto

object CarFactory {
    fun createMany(dtos: List<CarCreateDto>): List<Car> {
        return dtos.mapIndexed { index, dto ->
            Car(id = index, name = dto.name)
        }
    }
}
