package racingcar

import racingcar.model.CarName
import racingcar.model.Cars

fun interface RacingCarsFactory {

    fun createCars(carNames: List<CarName>): Cars
}
