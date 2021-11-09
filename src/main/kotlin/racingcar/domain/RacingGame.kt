package racingcar.domain

import racingcar.domain.cars.Cars
import racingcar.domain.cars.NumberOfCars
import racingcar.input.InputConsole
import racingcar.output.OutputConsole

class RacingGame(
    private val input: InputConsole,
    private val output: OutputConsole
) {
    private val currentTurn = CurrentTurn()

    fun start(): Unit = runCatching {
        racing(prepareRacingCars(), prepareTryTimesOfRace())
    }.onFailure {
        println(it.message)
    }.getOrThrow()

    private fun prepareRacingCars(): Cars {
        output.numberOfCarsMessage()
        val numberOfCars = input.numberOfCars()

        return Cars(
            numberOfCars = NumberOfCars(numberOfCars)
        )
    }

    private fun prepareTryTimesOfRace(): Int {
        output.tryTimesOfRace()
        return input.tryTimesOfRace()
    }

    private fun racing(cars: Cars, tryTimesOfRace: Int) {
        repeat((START_TRY_TIMES_OF_RACE..tryTimesOfRace).count()) {
            currentTurn.increaseTurn()
            cars.race()
            outputRacingDistance(cars)
        }
    }

    private fun outputRacingDistance(cars: Cars) {
        for (carPosition in cars.carsCurrentPosition) {
            output.positionOfCar(carPosition)
        }
        output.emptyLine()
    }

    companion object {
        private const val START_TRY_TIMES_OF_RACE = 1
    }
}
