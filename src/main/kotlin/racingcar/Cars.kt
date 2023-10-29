package racingcar

class Cars(val cars: List<Car>, private val powerGenerator: PowerGenerator) {
    fun move(): Cars {
        val movedCars = mutableListOf<Car>()
        for (car in cars) {
            movedCars.add(car.move(powerGenerator.generate()))
        }
        return Cars(movedCars, powerGenerator)
    }

    companion object {
        fun initializeWithNumberOfCars(numberOfCars: Int, powerGenerator: PowerGenerator): Cars {
            val cars = mutableListOf<Car>()
            for (i in 1..numberOfCars) {
                cars.add(Car())
            }
            return Cars(cars, powerGenerator)
        }
    }
}
