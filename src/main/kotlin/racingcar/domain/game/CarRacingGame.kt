package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule

class CarRacingGame private constructor(
    private val roundRange: IntRange,
    private val cars: List<Car>,
    private val carMover: CarMover,
    private val result: MutableList<CarRacingResult> = mutableListOf(),
) {
    fun run(): List<CarRacingResult> {
        roundRange.forEach { _ ->
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
            moveRule: MoveRule,
        ): CarRacingGame {
            val carMover = CarMover(
                moveRule = moveRule,
            )
            return CarRacingGame(
                cars = configuration.cars,
                carMover = carMover,
                roundRange = configuration.rounds,
            )
        }
    }
}
