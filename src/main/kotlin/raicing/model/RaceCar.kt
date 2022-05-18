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

    companion object {
        fun of(carInfos: List<CarInfo>): RaceCar =
            RaceCar(List(carInfos.size) { Car(carInfos[it]) })
    }
}
