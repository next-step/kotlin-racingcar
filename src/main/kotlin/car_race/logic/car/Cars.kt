package car_race.logic.car

import car_race.logic.system.MovingSystem

class Cars(
    private val cars: List<Car>
) {

    fun nextRound(movingSystem: MovingSystem) {
        cars.forEach { car ->
            car.nextRound(movingSystem)
        }
    }

    fun getNameAndPositionList(): List<Pair<CarName, CarPosition>> {
        return cars.map { car ->
            car.getNameAndPosition()
        }
    }

    fun getWinners(): List<Car> {
        val highestScore = cars.maxOf { car -> car.getPosition().getValue() }
        return cars.filter { car -> car.getPosition().getValue() == highestScore }
    }

    companion object {
        fun from(carNames: CarNames): Cars {
            return Cars(
                carNames.names.map { name ->
                    Car(name)
                }
            )
        }
    }
}
