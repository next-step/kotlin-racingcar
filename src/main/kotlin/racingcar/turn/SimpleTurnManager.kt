package racingcar.turn

import racingcar.racing.car.Car
import racingcar.racing.result.RacingResult
import racingcar.racing.rule.CarMovementRule

class SimpleTurnManager(
    override val totalSteps: Int,
    private val cars: List<Car>,
    private val rule: CarMovementRule
) : TurnManager {

    private var currentTurn = 0
    private val racingResult = arrayListOf<RacingResult>()

    override fun nextTurn(): List<RacingResult> {
        return racingResult.also {
            if (!isFinish()) {
                it.add(
                    getLastCars(it).race(rule)
                )
            }
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

    override fun isFinish() = currentTurn >= totalSteps

    override fun startRaceUntilFinish(): List<RacingResult> {
        var last = listOf<RacingResult>()
        while (!isFinish()) {
            last = nextTurn()
        }
        return last
    }
}
