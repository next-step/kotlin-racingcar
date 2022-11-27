package car_race.logic.car

import car_race.logic.system.MovingSystem

data class Cars(
    val cars: List<Car>
) {
    constructor(carNames: CarNames) : this(
        carNames.names.map { name ->
            Car(name)
        }
    )

    fun nextRound(movingSystem: MovingSystem): Cars {
        return Cars(
            cars.map { car ->
                car.nextRound(movingSystem)
            }
        )
    }

    fun getWinners(): Winners {
        val highestScore = cars.maxOf { car -> car.carPosition.position }
        return Winners(
            cars.filter { car ->
                car.carPosition.position == highestScore
            }
        )
    }

    fun getResult(): List<String> {
        return cars.map { car ->
            "${car.carName.name} : " + "-".repeat(car.carPosition.position + 1)
        }
    }
}
