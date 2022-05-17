package racing.model

import racing.port.RandomGeneratorPort

class Cars(private val cars: List<Car>) {

    fun moveAll(randomGenerator: RandomGeneratorPort): Cars {
        val movedCars = cars.map { it.moveForward(randomGenerator.generate()) }
        return Cars(movedCars)
    }

    fun toPrintableCars(separator: String = ""): String = cars.joinToString(separator)

    fun maxAll(): List<Car> {
        val maxCar = cars.maxOf { it }
        return cars.filter { maxCar.compareTo(it) == 0 }
    }

    companion object {
        fun empty(): Cars = Cars(emptyList())

        fun createWithNames(names: String, delimiters: String = ","): Cars =
            Cars(
                splitNames(names, delimiters)
                    .map(::createCarWithName)
                    .toList()
            )

        private fun splitNames(names: String, delimiters: String): List<String> =
            names.split(delimiters).map(String::trim)

        private fun createCarWithName(name: String): Car = Car(0, name)
    }
}
