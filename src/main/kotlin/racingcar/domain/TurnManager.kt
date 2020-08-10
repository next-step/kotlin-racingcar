package racingcar.domain

class TurnManager(
    private val totalSteps: Int,
    private val cars: List<Car>,
    private val rule: CarMovementRule
) {

    private val racingResult = mutableListOf<RacingResult>()

    private fun nextTurn(): List<RacingResult> {
        return racingResult.also {
            it.add(
                getLastCars(it).race(rule)
            )
        }
    }

    private fun List<Car>.race(rule: CarMovementRule): RacingResult {
        return RacingResult(moveEach(rule))
    }

    private fun List<Car>.moveEach(rule: CarMovementRule): List<Car> {
        return map { car ->
            car.moveIf { rule.rule() }
        }
    }

    private fun getLastCars(racingResults: List<RacingResult>): List<Car> {
        return racingResults.lastOrNull()?.cars ?: cars
    }

    fun startRaceUntilFinish(): List<RacingResult> {
        var last = listOf<RacingResult>()
        repeat(totalSteps) { last = nextTurn() }
        return last
    }
}
