package racingcar.domain

import racingcar.domain.cars.Cars
import racingcar.domain.cars.GameStartLab
import racingcar.input.InputConsole
import racingcar.output.OutputConsole

class RacingGame(
    private val input: InputConsole,
    private val output: OutputConsole,
) {
    fun start(gameStartLab: GameStartLab = GameStartLab()): Unit = runCatching {
        val racingCars = Pit.courseInRacingCars(input, output)
        val finalLab = ControlTower.decideRacingLabs(input, output)

        racing(racingCars, finalLab, gameStartLab)
    }.getOrElse {
        output.errorMessage(it.message ?: UNKNOWN_ERROR_MESSAGE)
    }

    private fun racing(cars: Cars, finalLab: Int, gameStartLabs: GameStartLab = GameStartLab()) {
        repeat((START_LAB..finalLab).count()) {
            gameStartLabs.increase()
            cars.race()
            output.labsOfRacingCars(cars.racingLabs)
        }
    }

    companion object {
        private const val START_LAB = 1
        private const val UNKNOWN_ERROR_MESSAGE = "[ERROR] : unknown error occurred while the racing game"
    }
}
