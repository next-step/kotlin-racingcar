package racingcar.domain

class Winner(private val cars: List<Car>) {
    fun getWinners() = cars

    companion object {
        @JvmStatic
        fun from(cars: Cars) = Winner(cars.findMaxDistanceCars())
    }
}
