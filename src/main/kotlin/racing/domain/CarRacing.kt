package racing.domain

import racing.dto.Car
import racing.dto.Winners

class CarRacing {
    fun moveCars(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) {
            cars.forEach { car ->
                car.go { car.goIfAboveRequireGoValue() }
            }
        }
    }

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { carName -> Car(carName) }
    }

    fun pickWinners(cars: List<Car>): Winners {
        val maxDistance: Int = cars.maxOf { car -> car.turnOfPosition.last() }
        val winnerNames: List<String> = cars.filter { car ->
            car.turnOfPosition.last() >= maxDistance
        }.map { car ->
            car.name
        }

        return Winners(winnerNames)
    }
}
