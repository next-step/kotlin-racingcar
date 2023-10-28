package game

class CarFleet private constructor(private val cars: List<Car>) {

    fun findWinner(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.isSamePosition(maxPosition) }.map { it.name }
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
