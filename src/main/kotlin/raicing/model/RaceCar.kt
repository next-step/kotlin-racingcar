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

    fun getMaxPositionCars(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun of(carInfos: List<CarInfo>): RaceCar =
            RaceCar(carInfos.map { Car(it) })
    }
}
