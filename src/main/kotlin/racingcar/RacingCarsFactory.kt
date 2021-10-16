package racingcar

import racingcar.model.CarCount
import racingcar.model.Cars

fun interface RacingCarsFactory {

    fun createCars(carCount: CarCount): Cars
}
