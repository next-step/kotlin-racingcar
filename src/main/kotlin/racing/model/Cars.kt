package racing.model

import racing.port.RandomGeneratorPort

class Cars(private val cars: List<Car>) {

    fun moveAll(randomGenerator: RandomGeneratorPort): Cars {
        val movedCars = cars.map { it.moveForward(randomGenerator.generate()) }
        return Cars(movedCars)
    }

    fun toPrintableCars(separator: String = ""): String = cars.joinToString(separator, postfix = "\n")

    fun maxAll(): List<Car> {
        val maxCar = cars.maxOf { it }
        return cars.filter { maxCar.compareTo(it) == 0 }
    }

    fun getWinners(): Winner = Winner(cars)

    companion object {
        fun empty(): Cars = Cars(emptyList())

        fun createWithNames(names: List<String>): Cars =
            Cars(
                names
                    .map(::createCarWithName)
                    .toList()
            )

        private fun createCarWithName(name: String): Car = Car(0, name)
    }
}
