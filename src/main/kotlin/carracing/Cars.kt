package carracing

class Cars private constructor(private val cars: List<Car>) {
    companion object {
        fun create(cars: List<Car>): Cars {
            return Cars(cars)
        }

        fun create(
            totalCar: Int,
            initialPosition: Int,
            minConditionToMove: Int,
        ): Cars {
            val cars = mutableListOf<Car>()
            for (count in 0 until totalCar) {
                cars.add(Car(initialPosition, minConditionToMove))
            }
            return Cars(cars)
        }
    }

    fun moveAllCars(numberGenerator: NumberGenerator) {
        for (car in cars) {
            val power = numberGenerator.generate()
            car.move(power)
        }
    }

    fun getCarPositions(): List<Int> {
        return cars.map { it.getPosition() }
    }
}
