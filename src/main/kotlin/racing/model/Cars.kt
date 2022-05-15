package racing.model

import racing.port.RandomGeneratorPort

class Cars(private val cars: List<Car>) {

    fun moveAll(randomGenerator: RandomGeneratorPort): Cars {
        val movedCars = cars.map { it.moveForward(randomGenerator.generate()) }
        return Cars(movedCars)
    }

    fun toPrintableCars(separator: String = ""): String = cars.joinToString(separator)

    fun winnerNames(): List<String> {
        val longestCar = getLongestDistance()
        return getWinnerNames(longestCar)
    }

    private fun getWinnerNames(car: Car): List<String> =
        cars
            .filter { it.isSamePosition(car) }
            .map(Car::toString)
            .map { it.split(":") }
            .map { it[0] }

    private fun getLongestDistance(): Car = cars.maxOf { it }

    companion object {
        fun empty(): Cars = Cars(emptyList())

        fun create(size: Int): Cars = Cars(List(size) { Car.spawnAt(0) })

        fun createWithNames(names: String, delimiters: String = ","): Cars =
            Cars(
                splitNames(names, delimiters)
                    .map(::createCarWithName)
                    .toList()
            )

        private fun splitNames(names: String, delimiters: String): List<String> =
            names.split(delimiters).map(String::trim)

        private fun createCarWithName(name: String): Car =
            Car.spawnWithPositionAndName(0, name)
    }
}
