package racingcar

class Cars(val cars: List<Car>, private val powerGenerator: PowerGenerator) {
    init {
        require(cars.isNotEmpty()) { "자동차는 최소 한 대 이상 존재해야 합니다." }
    }

    fun move(): Cars {
        val movedCars = mutableListOf<Car>()
        cars.forEach { movedCars.add(it.move(powerGenerator.generate())) }
        return Cars(movedCars, powerGenerator)
    }

    fun findWinner(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun initialize(numberOfCars: Int, names: List<String>, powerGenerator: PowerGenerator): Cars {
            val cars = mutableListOf<Car>()
            repeat(numberOfCars) {
                cars.add(Car(names[it]))
            }
            return Cars(cars, powerGenerator)
        }
    }
}
