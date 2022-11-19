package racingcar.fixture

import racingcar.CarName
import racingcar.dto.CarCreateDto

object CarCreateDtoFixture {
    fun getMany(amount: Int): List<CarCreateDto> {
        return List(amount) { CarCreateDto(name = CarName(value = "동구")) }
    }
}
