package racing.model

import racing.port.RandomGeneratorPort

class Cars(private val cars: List<Car>) {

    fun moveAll(randomGenerator: RandomGeneratorPort): Cars {
        val movedCars = cars.map { it.moveForward(randomGenerator.generate()) }
        return Cars(movedCars)
    }

    fun toPrintableCars(separator: String = ""): String = cars.joinToString(separator)

    companion object {
        fun empty(): Cars = Cars(emptyList())

        fun create(size: Int): Cars = Cars(List(size) { Car.spawnAt(0) })
    }
}
