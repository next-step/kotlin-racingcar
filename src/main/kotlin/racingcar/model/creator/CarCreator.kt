package racingcar.model.creator

import racingcar.model.Car
import racingcar.model.CarName

interface CarCreator {
    fun createCar(carName: CarName): Car
}
