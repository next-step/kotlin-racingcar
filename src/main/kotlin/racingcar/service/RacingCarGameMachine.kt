package racingcar.service

import racingcar.domain.Car
import racingcar.service.dto.GameResultDto
import racingcar.service.strategy.NumberGenerateStrategy

class RacingCarGameMachine(private val numberGenerate: NumberGenerateStrategy) {

    fun play(carCount: Int, tryCount: Int): List<GameResultDto> {
        var cars = List(carCount) { Car() }
        return (1..tryCount).map { stage ->
            cars = cars.map { car -> car.move(numberGenerate.generate()) }
            cars.let { cars -> GameResultDto(stage, cars) }
        }
    }
}
