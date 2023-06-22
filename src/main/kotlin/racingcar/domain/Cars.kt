package racingcar.domain

class Cars(carNames: List<String>) {
    val cars: List<Car>
    val size: Int
        get() = cars.size

    init {
        this.cars = carNames.map { Car(it) }
    }

    val namesAndPositions: List<Pair<String, Int>>
        get() {
            return cars.map { Pair(it.carName.name, it.position) }
        }

    val winners: List<Car>
        get() {
            val maxPosition = cars.maxOf { it.position }
            return cars.filter { it.position == maxPosition }
        }

    fun moveAllCars(conditionGenerator: ConditionGenerator) {
        for (car in cars) {
            moveCar(conditionGenerator, car)
        }
    }

    private fun moveCar(conditionGenerator: ConditionGenerator, car: Car) {
        conditionGenerator.generate().let { condition ->
            car.move(condition)
        }
    }
}
