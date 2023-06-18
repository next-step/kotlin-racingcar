package racingcar.domain

import racingcar.dto.RaceResult

class RaceResultEstimator {

    fun estimate(cars: List<Car>): RaceResult {
        val maxLocation: Int = findMaxLocation(cars)
        val winnerNameSet = findWinnerName(cars = cars, maxLocation = maxLocation)
        return RaceResult(winnerNameSet = winnerNameSet)
    }

    private fun findMaxLocation(cars: List<Car>): Int {
        var maxLocation = 0
        for (car in cars) {
            if (car.location > maxLocation)
                maxLocation = car.location
        }
        return maxLocation
    }

    private fun findWinnerName(cars: List<Car>, maxLocation: Int): Set<String> {
        val result: MutableSet<String> = mutableSetOf()
        for (car in cars) {
            if (car.location == maxLocation) {
                result.add(car.name)
            }
        }
        return result.toSet()
    }
}
