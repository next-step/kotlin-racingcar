package racingcar.domain

import racingcar.communication.output.Output
import racingcar.communication.output.OutputConsole
import racingcar.domain.cars.Cars
import racingcar.domain.cars.NumberOfRacingCars
import racingcar.domain.racing.FinalLab

class RacingGame(
    private val output: Output = OutputConsole(),
) {
    fun start(
        racingCars: Cars = Cars(numberOfRacingCars = NumberOfRacingCars(STARTING_NUMBER_OF_RACING_CARS)),
        finalLab: FinalLab = FinalLab(value = 1)
    ) = runCatching {
        racing(racingCars, finalLab)
    }.onFailure {
        output.errorMessage(it.message ?: RACING_GAME_ERROR_MESSAGE)
    }

    fun racing(cars: Cars, finalLab: FinalLab) {
        repeat((finalLab.value)) {
            cars.races()
            output.labsOfRacingCars(cars.currentRacingLabs)
        }
    }

    companion object {
        private const val STARTING_NUMBER_OF_RACING_CARS = 1
        private const val RACING_GAME_ERROR_MESSAGE = "[ERROR] : error occurred while the racing game"
    }
}
