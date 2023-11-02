package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.car.capture
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule

class CarRacingGame private constructor(
    private val roundCount: RoundCount,
    private val cars: List<Car>,
    private val carMover: CarMover,
    private val result: MutableList<CarRacingResult> = mutableListOf(),
) {

    fun run(): List<CarRacingResult> {
        repeat(roundCount.value) {
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
            roundCount: RoundCount,
            cars: List<Car>,
            moveRule: MoveRule,
        ): CarRacingGame =
            CarRacingGame(
                roundCount = roundCount,
                cars = cars,
                carMover = CarMover(moveRule)
            )
    }
}
