package racingcar.model

import racingcar.model.creator.CarCreator

object CarsFactory {
    fun createCars(carCreator: CarCreator, carNames: List<CarName>): Cars {
        val cars = Cars()

        carNames.forEach {
            cars.addCar(carCreator.createCar(it))
        }

        return cars
    }
}
