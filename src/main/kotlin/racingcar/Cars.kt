package racingcar

class Cars(val cars: List<Car>, val powerGenerator: PowerGenerator) {

    companion object {

        @JvmStatic
        fun initializeWithNumberOfCars(numberOfCars: Int, powerGenerator: PowerGenerator): Cars {
            val cars = mutableListOf<Car>()
            for (i in 1..numberOfCars) {
                cars.add(Car(0))
            }
            return Cars(cars, powerGenerator)
        }
    }

    fun move(): Cars {
        val movedCars = mutableListOf<Car>()
        for (car in cars) {
            movedCars.add(car.move(powerGenerator.generate()))
        }
        return Cars(movedCars, powerGenerator)
    }
}
