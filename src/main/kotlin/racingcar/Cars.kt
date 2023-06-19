package racingcar

class Cars {
    private val cars = mutableListOf<Car>()

    fun add(car: Car) {
        cars.add(car)
    }

    fun getPositionOfCars(): List<Int> {
        return cars.map { it.position }
    }

    fun getNameAndPositionOfCars(): List<Pair<String, Int>> {
        return cars.map { Pair(it.name, it.position) }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun moveAllCars(conditionGenerator: ConditionGenerator) {
        for (car in cars) {
            conditionGenerator.generate().let { condition ->
                car.move(condition)
            }
        }
    }
}
