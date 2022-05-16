package racing.model

data class Winner(private val cars: List<Car>) {

    override fun toString(): String {
        val longestCar = getLongestDistance()
        return getWinnerNames(longestCar).joinToString(", ")
    }

    private fun getWinnerNames(car: Car): List<String> =
        cars
            .filter { it.compareTo(car) == 0 }
            .map(Car::toString)
            .map { it.split(":") }
            .map { it[0] }

    private fun getLongestDistance(): Car = cars.maxOf { it }
}
