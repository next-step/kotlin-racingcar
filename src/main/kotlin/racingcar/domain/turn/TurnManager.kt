package racingcar.domain.turn

import racingcar.domain.car.Car
import racingcar.domain.result.RacingResult
import racingcar.domain.rule.CarMovementRule

class TurnManager(
    val totalSteps: Int,
    private val cars: List<Car>,
    private val rule: CarMovementRule
) {

    private var currentTurn = 0
    private val racingResult = mutableListOf<RacingResult>()

    fun nextTurn(): List<RacingResult> {
        return racingResult.also {
            it.add(
                getLastCars(it).race(rule)
            )
        }
    }

    fun List<Car>.race(rule: CarMovementRule): RacingResult {
        currentTurn++
        return RacingResult(moveEach(rule))
    }

    fun List<Car>.moveEach(rule: CarMovementRule): List<Car> {
        return map { car ->
            car.moveIf { rule.rule() }
        }
    }

    fun getLastCars(racingResults: List<RacingResult>): List<Car> {
        return racingResults.lastOrNull()?.cars ?: cars
    }

    fun startRaceUntilFinish(): List<RacingResult> {
        var last = listOf<RacingResult>()
        repeat(totalSteps) { last = nextTurn() }
        return last
    }
}
