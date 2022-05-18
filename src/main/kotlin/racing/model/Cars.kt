package racing.model

import racing.port.RandomGeneratorPort

class Cars(private val cars: List<Car>) : Iterator<Car> {

    private var index = 0

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

    override fun hasNext(): Boolean = index < cars.size

    override fun next(): Car = cars[index++]

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
