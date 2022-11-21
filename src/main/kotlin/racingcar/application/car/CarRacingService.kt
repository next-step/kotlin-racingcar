package racingcar.application.car

import racingcar.domain.car.Car
import racingcar.domain.car.CarFactory
import racingcar.domain.car.CarName
import racingcar.domain.car.CarRacingResult

class CarRacingService {
    fun run(nameOfCars: Set<CarName>, moves: Int): List<CarRacingResult> {
        val cars = CarFactory.create(nameOfCars)

        return startRace(cars, moves)
    }

    fun startRace(cars: List<Car>, moves: Int): List<CarRacingResult> {
        return List(moves) {
            val distances = mutableMapOf<CarName, Int>()

            cars.forEach {
                distances[it.name] = it.move()
            }
            distances
        }
    }

    fun findWinners(finalResult: CarRacingResult): Set<CarName> {
        return finalResult.filter { (_, distance) ->
            distance == finalResult.maxOf { (_, distance) -> distance }
        }.keys
    }
}
