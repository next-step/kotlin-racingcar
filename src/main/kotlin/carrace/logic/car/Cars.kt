package carrace.logic.car

import carrace.logic.system.MovingSystem

data class Cars(
    val cars: List<Car>
) {
    constructor(carNames: CarNames) : this(
        carNames.names.map { name ->
            Car(name)
        }
    )

    fun getWinners(): Winners {
        return Winners.from(cars)
    }

    fun nextRound(movingSystem: MovingSystem): CarInfos {
        return CarInfos(
            cars.map { car ->
                car.nextRound(movingSystem)
            }
        )
    }
}
