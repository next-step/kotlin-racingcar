package racingcar

import racingcar.model.CarCount
import racingcar.model.Cars

fun interface CarFactory {

    fun createCars(carCount: CarCount) : Cars
}