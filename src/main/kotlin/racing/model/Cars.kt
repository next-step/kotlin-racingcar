package racing.model

import racing.port.RandomGeneratorPort

class Cars(private val cars: List<Car>) : List<Car> by cars {

    init {
        require(cars.isNotEmpty())
    }

    fun moveAll(randomGenerator: RandomGeneratorPort): Cars {
        val movedCars = cars.map { it.moveForward(randomGenerator.generate()) }
        return Cars(movedCars)
    }

    fun maxAll(): List<Car> {
        if (cars.isEmpty()) {
            return emptyList()
        }
        val maxCar = cars.maxOf { it }
        return cars.filter { maxCar.compareTo(it) == 0 }
    }

    fun winnerNames(): List<String> = maxAll().map(Car::name)

    companion object {
        fun createWithNames(names: List<String>): Cars =
            Cars(
                names
                    .map(::createCarWithName)
                    .toList()
            )

        private fun createCarWithName(name: String): Car = Car(0, name)
    }
}
