package racingcar.domain

import racingcar.domain.checker.RaceConditionChecker

class RaceManager(
    private val moveCount: Int,
    private var cars: List<Car>,
) {
    fun startRacing(raceConditionChecker: RaceConditionChecker): RaceResult {
        var raceHistories: List<RaceHistory> = emptyList()
        repeat(moveCount) {
            cars = raceCars(cars, raceConditionChecker)
            raceHistories = raceHistories + RaceHistory(cars)
        }
        return RaceResult(raceHistories)
    }

    private fun raceCars(
        cars: List<Car>,
        raceConditionChecker: RaceConditionChecker,
    ): List<Car> =
        cars.map {
            it.moveIfPossible(raceConditionChecker.isAdvancePossible())
        }
}
