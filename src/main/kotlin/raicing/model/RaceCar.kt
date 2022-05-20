package raicing.model

import raicing.strategy.MovingStrategy

class RaceCar(private val cars: List<Car>) {
    fun getCars() = cars

    fun raceOnce(movingStrategy: MovingStrategy): RaceCar {
        val afterRaceCars = cars.map { car ->
            car.moveForward(movingStrategy)
        }
        return RaceCar(afterRaceCars)
    }

    fun getMaxPosition() = cars.maxOf { it.position }

    fun getCarsByPosition(position: Int): List<Car> {
        return cars.filter { it.position == position }
    }

    companion object {
        fun of(carNames: List<CarName>): RaceCar =
            RaceCar(carNames.map { Car(it) })
    }
}
