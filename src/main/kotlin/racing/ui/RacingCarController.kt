package racing.ui

import racing.domain.car.RacingCar
import racing.domain.car.RacingCarFactory
import racing.domain.movement.MoveStrategy

class RacingCarController(private val moveStrategy: MoveStrategy) {
    fun run(carNames: String, tryCount: Int): List<RacingCarDtos> {
        val racingCars = RacingCarFactory.createRacingCars(carNames)
        val racingRecords = racingCars.race(tryCount, moveStrategy)
        return toDto(racingRecords)
    }

    private fun toDto(racingRecords: List<List<RacingCar>>) =
        racingRecords.map { it -> RacingCarDtos(it.map { RacingCarDto.of(it) }) }
}
