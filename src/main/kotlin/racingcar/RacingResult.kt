package racingcar

class RacingResult(val round: Int, private val cars: Cars) {

    fun carsResult(): List<Car> {
        return cars.value
    }

    fun winners(): List<Car> {
        return cars.longestMovedCars()
    }

    companion object {
        fun of(round: Int, cars: Cars): RacingResult {
            return RacingResult(round, cars)
        }
    }
}
