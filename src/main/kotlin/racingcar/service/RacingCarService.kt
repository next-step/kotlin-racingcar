package racingcar.service

import racingcar.dto.RacingCarDto
import racingcar.model.Forward
import racingcar.model.RacingCar
import racingcar.model.TryCount
import racingcar.model.Winner

private const val DELIMITER = ","

class RacingCarService(
    private val tryCount: TryCount,
    private val forward: Forward,
) {
    fun readRacingCarNames(input: String): List<String> {
        return input.split(DELIMITER).map { it.trim() }.filter { it.isNotEmpty() }
    }

    fun readTryCount(input: Int): Int {
        return tryCount.getTryCount(input)
    }

    fun runRace(
        carNames: List<String>,
        tryCount: Int,
    ): List<RacingCar> {
        val raceCars = carNames.map { RacingCar.from(it) }

        repeat(tryCount) {
            raceCars.forEach { car ->
                car.race { forward.pickRandomNumberInRange() >= 4 }
            }
        }

        return raceCars
    }

    fun determineWinners(raceCars: List<RacingCar>): List<String> {
        return Winner.determineWinners(raceCars)
    }

    fun mapToDtos(raceCars: List<RacingCar>): List<RacingCarDto> {
        return raceCars.map { RacingCarDto(it.carName, it.position) }
    }
}
