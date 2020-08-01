package racing.infrastructure

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RacingState

class RacingGame {

    companion object {
        const val MINIMUM_RANGE_NUMBER = 0
        const val MAXIMUM_RANGE_NUMBER = 9
        const val MOVE_CONDITION_NUMBER = 4
    }

    fun start(racingState: RacingState): List<Cars> {

        var result = mutableListOf<Cars>()

        // Car Instance List 생성
        val cars = Car().makeCars(racingState.names)

        // 전진 시도
        repeat(racingState.attempt) {
            val cars = cars.map {
                it.move()
                Car(it.name, it.distance)
            }
            result.add(cars)
        }

        return result
    }

    fun longestDistance(cars: Cars): Int? {
        return cars.map { it.distance }.max()
    }
}
