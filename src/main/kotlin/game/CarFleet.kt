package game

class CarFleet private constructor(private val cars: List<Car>) {

    fun findWinner(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.isSamePosition(maxPosition) }.map { it.name }
    }

    fun advance(retryCount: Int, moveConditionGenerator: MoveConditionGenerator, action: (List<Car>) -> Unit) {
        repeat(retryCount) {
            cars.forEach { car -> car.move(moveConditionGenerator.generate()) }
            action(cars)
        }
    }

    companion object {
        fun of(carNames: List<String>): CarFleet {
            return CarFleet(carNames.map { Car.of(it) })
        }

        fun from(cars: List<Car>): CarFleet {
            return CarFleet(cars)
        }
    }
}
