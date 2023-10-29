package racingcar

class Cars(val cars: List<Car>, private val powerGenerator: PowerGenerator) {
    fun move(): Cars {
        val movedCars = mutableListOf<Car>()
        cars.forEach { movedCars.add(it.move(powerGenerator.generate())) }
        return Cars(movedCars, powerGenerator)
    }

    companion object {
        fun initializeWithNumberOfCars(numberOfCars: Int, powerGenerator: PowerGenerator): Cars {
            val cars = mutableListOf<Car>()
            repeat(numberOfCars) {
                cars.add(Car())
            }
            return Cars(cars, powerGenerator)
        }
    }
}
