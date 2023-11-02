package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.car.capture
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule

class CarRacingGame private constructor(
    private val roundCount: RoundCount,
    private val cars: List<Car>,
    private val carMover: CarMover,
) {

    fun run(): List<CarRacingResult> =
        buildList {
            repeat(roundCount.value) {
                runRound()
                add(record())
            }
        }

    private fun runRound() {
        carMover.move(cars)
    }

    private fun record(): CarRacingResult =
        CarRacingResult(cars.map { it.capture() })

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
