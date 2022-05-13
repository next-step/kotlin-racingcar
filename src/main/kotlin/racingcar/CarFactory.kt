package racingcar

import racingcar.model.CarName
import racingcar.model.Cars

fun interface CarFactory {

    fun createCars(carNames: List<CarName>) : Cars
}
