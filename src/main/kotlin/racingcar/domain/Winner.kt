package racingcar.domain

class Winner(private val cars: List<Car>) {
    fun getWinners() = cars

    companion object {
        private const val ZERO = 0

        @JvmStatic
        fun find(cars: Cars): Winner {
            val max: Int = getMaxDistance(cars.getCars())

            return if (max == ZERO) {
                Winner(emptyList())
            } else {
                Winner(cars.getCars().filter { it.getDistance() == max })
            }
        }

        private fun getMaxDistance(cars: List<Car>) =
            cars.maxOf { it.getDistance() }
    }
}
