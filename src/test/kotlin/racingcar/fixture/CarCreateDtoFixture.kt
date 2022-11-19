package racingcar.fixture

import racingcar.dto.CarCreateDto

object CarCreateDtoFixture {
    fun getMany(amount: Int): List<CarCreateDto> {
        return (1..amount).map { CarCreateDto(name = "relkimm") }
    }
}
