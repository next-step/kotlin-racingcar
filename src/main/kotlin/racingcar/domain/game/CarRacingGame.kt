package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.car.capture
import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.result.CarRacingResult

class CarRacingGame private constructor(
    private val round: RoundCount,
    private val cars: List<Car>,
    private val carMover: CarMover,
    private val result: MutableList<CarRacingResult> = mutableListOf(),
) {

    fun run(): List<CarRacingResult> {
        repeat(round.value) {
            runRound()
            record()
        }
        return result.toList()
    }

    private fun runRound() {
        carMover.move(cars)
    }

    private fun record() =
        result.add(
            CarRacingResult(
                cars = cars.map { it.capture() }
            )
        )

    companion object {
        fun set(
            configuration: CarRacingConfiguration,
        ): CarRacingGame =
            CarRacingGame(
                cars = configuration.cars,
                carMover = CarMover(configuration.moveRule),
                round = configuration.roundCount
            )
    }
}
