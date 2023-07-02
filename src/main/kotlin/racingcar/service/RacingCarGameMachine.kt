package racingcar.service

import racingcar.domain.Car
import racingcar.service.dto.GameResultDto
import racingcar.service.strategy.NumberGenerateStrategy

class RacingCarGameMachine(private val numberGenerate: NumberGenerateStrategy) {

    fun play(carNames: List<String>, tryCount: Int): List<GameResultDto> {
        var cars = carNames.map { name -> Car(name) }
        return (1..tryCount).map { stage ->
            cars = cars.map { car -> car.move(numberGenerate.generate()) }
            GameResultDto(stage, cars)
        }
    }

    fun getWinners(gameResults: List<GameResultDto>): List<String> {
        val lastStage = gameResults.maxByOrNull { it.stage } ?: throw IllegalStateException("게임 결과가 없습니다.")
        val maxPosition = lastStage.cars.maxOfOrNull { it.position } ?: 0
        return lastStage.cars.filter { it.position == maxPosition }.map { it.name }
    }
}
