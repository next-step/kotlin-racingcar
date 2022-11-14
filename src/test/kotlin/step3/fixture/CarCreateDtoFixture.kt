package step3.fixture

import step3.dto.CarCreateDto

object CarCreateDtoFixture {
    fun getMany(amount: Int): List<CarCreateDto> {
        return (1..amount).map { CarCreateDto(name = "relkimm") }
    }
}
