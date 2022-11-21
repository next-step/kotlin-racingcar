package car_race.logic.car

import car_race.logic.system.MovingSystem

class Cars(
    val cars: List<Car>
) {
    constructor(carNames: CarNames) : this(
        carNames.names.map { name ->
            Car(name)
        }
    )

    fun nextRound(movingSystem: MovingSystem) {
        cars.forEach { car ->
            car.nextRound(movingSystem)
        }
    }

    fun getWinners(): List<Car> {
        val highestScore = cars.maxOf { car -> car.carPosition.position }
        return cars.filter { car -> car.carPosition.position == highestScore }
    }
}
