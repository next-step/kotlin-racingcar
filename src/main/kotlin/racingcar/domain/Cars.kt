package racingcar.domain

import racingcar.util.generate

class Cars(var cars: List<Car>) {

    fun operateCars(): List<Car> {
        cars = cars.map { car ->
            car.move(generate())
        }
        return cars
    }

    fun isWinner(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
