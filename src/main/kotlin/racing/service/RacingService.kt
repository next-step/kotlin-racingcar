package racing.service

import racing.model.Car
import racing.model.Name
import racing.model.RacingHistory
import racing.model.RoundHistory
import racing.model.generator.RandomGenerator
import racing.model.move.MoveThresholdStrategy

class RacingService {

    private val strategy = MoveThresholdStrategy(RandomGenerator())

    fun racing(participates: ArrayDeque<String>, roundCount: Int): RacingHistory {
        val racingHistory = RacingHistory()
        racingHistory.appendRound(ready(participates))
        repeat(roundCount - 1) {
            racingHistory.appendRound(nextRound(racingHistory.lastRound()))
        }
        return racingHistory
    }

    private fun ready(participates: ArrayDeque<String>): RoundHistory {
        val cars = ArrayDeque(
            participates.map { Car(Name(it)) }
        )
        requireDistinct(cars)
        return RoundHistory(cars)
    }

    private fun requireDistinct(cars: ArrayDeque<Car>) {
        require(isUniqueNames(cars)) { "자동차 name 은 중복이 허용되지 않습니다" }
    }

    private fun isUniqueNames(cars: ArrayDeque<Car>): Boolean {
        return countOfNameDistinct(cars) == cars.size
    }

    private fun countOfNameDistinct(cars: ArrayDeque<Car>): Int {
        return cars
            .map { it.name.value }
            .distinct()
            .size
    }

    private fun nextRound(preRoundHistory: RoundHistory): RoundHistory {
        return RoundHistory(
            ArrayDeque(
                preRoundHistory
                    .results
                    .map { it.move(strategy).copy() }
            )
        )
    }
}
