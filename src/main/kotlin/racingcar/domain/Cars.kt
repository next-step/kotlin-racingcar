package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun getCars() = cars

    fun race(): Cars {
        return Cars(cars.map { it.moveOrNot() })
    }

    fun findMaxDistanceCars(): List<Car> {
        val max: Int = getMaxDistance(this.cars)

        return if (max == ZERO) {
            emptyList()
        } else {
            this.cars.filter { it.getDistance() == max }
        }
    }

    private fun getMaxDistance(cars: List<Car>) =
        cars.maxOf { it.getDistance() }

    companion object {
        private const val ZERO = 0
    }
}
