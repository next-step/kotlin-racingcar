package racingcar.domain

class RaceResultEstimator {

    fun estimate(cars: List<Car>): Set<String> {
        val maxLocation: Int = findMaxLocation(cars)
        return findWinnerName(cars = cars, maxLocation = maxLocation)
    }

    private fun findMaxLocation(cars: List<Car>): Int {
        var maxLocation: Int = 0
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
