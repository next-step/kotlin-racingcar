package racingcar

class Cars {
    private val cars = mutableListOf<Car>()

    fun add(car: Car) {
        cars.add(car)
    }

    fun getSize(): Int {
        return cars.size
    }

    fun getNamesAndPositions(): List<Pair<String, Int>> {
        return cars.map { Pair(it.name, it.position) }
    }

    fun getWinners(): List<Car> {
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
