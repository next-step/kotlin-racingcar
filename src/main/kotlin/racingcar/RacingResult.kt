package racingcar

class RacingResult(val round: Int, private val cars: Cars) {

    fun carsResult(): List<Car> {
        return cars.value
    }

    companion object {
        fun of(round: Int, cars: Cars): RacingResult {
            return RacingResult(round, cars)
        }
    }
}
