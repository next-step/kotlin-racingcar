package racingcar.fixture

import racingcar.dto.CarCreateDto

object CarCreateDtoFixture {
    fun getMany(amount: Int): List<CarCreateDto> {
        return List(amount) { CarCreateDto(name = "relkimm") }
    }
}
