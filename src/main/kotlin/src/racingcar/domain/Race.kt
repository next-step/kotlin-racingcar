package src.racingcar.domain

import src.racingcar.getCarMoveRandomValue

class Race(
    val cars: MutableList<Car> = mutableListOf()
) {

    fun create(carNames: List<String>): Race {
        for (carName in carNames) {
            cars.add(Car(carName))
        }

        return this
    }

    fun start(): List<Car> {
        for (car in cars) {
            car.move(getCarMoveRandomValue())
        }
        return cars
    }
}
