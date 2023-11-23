package racingcar.domain

import racingcar.MoveStrategy
import racingcar.RandomMoveStrategy

class Cars(
    val cars: List<Car>,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
    private val racingHistory: RacingHistory = RacingHistory(),
) {
    fun moveCars(attemptNumber: Int) {
        repeat(attemptNumber) {
            cars.forEach { it.move(moveStrategy.move()) }
            racingHistory.record(cars)
        }
    }

    fun getWinners(): List<Car> {
        val maxMoveCount = cars.maxOfOrNull { it.moveCount } ?: 0
        return cars.filter { it.moveCount == maxMoveCount }
    }

    fun getRacingHistory(): RacingHistory {
        return racingHistory
    }
}
