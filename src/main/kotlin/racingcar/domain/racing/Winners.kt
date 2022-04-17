package racingcar.domain.racing

import racingcar.domain.car.Car

class Winners(private val carsHistory: CarsHistory) {

    fun find(): List<Car> = carsHistory.maxDrivenCars
}
