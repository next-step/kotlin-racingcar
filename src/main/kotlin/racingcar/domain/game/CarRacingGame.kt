package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.configuration.CarRacingGameConfiguration
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule

class CarRacingGame private constructor(
    private val roundRange: IntRange,
    private val result: CarRacingResult,
    private val cars: List<Car>,
    private val carMover: CarMover,
) {
    fun run(): CarRacingResult {
        roundRange.forEach { roundNumber ->
            runRound()
            record(roundNumber)
        }
        return result
    }

    private fun runRound() {
        carMover.move(cars)
    }

    private fun record(roundNumber: Int) {
        TODO()
        // result.record(roundNumber, cars)
    }

    companion object {
        fun set(
            configuration: CarRacingGameConfiguration,
            result: CarRacingResult,
            moveRule: MoveRule,
        ): CarRacingGame {
            val carMover = CarMover(
                moveRule = moveRule,
            )
            return CarRacingGame(
                cars = configuration.cars,
                carMover = carMover,
                roundRange = configuration.roundRange,
                result = result,
            )
        }
    }
}
