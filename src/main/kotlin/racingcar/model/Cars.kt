package racingcar.model

import racingcar.model.creator.CarCreator

class Cars(
    carCreator: CarCreator,
    numberOfCar: NaturalNumber,
) {
    private val cars = List(numberOfCar.number) { carCreator.createCar() }

    fun move() {
        cars.forEach { it.move() }
    }

    fun getCars(): List<Car> {
        return cars
    }
}
