package racingcar.domain.fixture

import racingcar.domain.CarName
import racingcar.domain.dto.CarCreateDto

object CarCreateDtoFixture {
    fun getMany(amount: Int): List<CarCreateDto> {
        return List(amount) { CarCreateDto(name = CarName(value = "동구")) }
    }
}
