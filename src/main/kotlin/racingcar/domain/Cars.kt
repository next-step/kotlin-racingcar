package racingcar.domain

class Cars private constructor(private val numberGenerator: NumberGenerator, private val cars: List<Car>) {
    val positions: Positions
        get() = Positions(cars.map { Position(it.name, it.position) })

    fun move(): Cars {
        val newCars = cars.map { it.move(numberGenerator.generate()) }
        return Cars(numberGenerator, newCars)
    }

    companion object {
        fun create(numberGenerator: NumberGenerator, names: List<String>): Cars {
            val cars = names.map { Car(it) }
            return Cars(numberGenerator, cars)
        }
    }
}
