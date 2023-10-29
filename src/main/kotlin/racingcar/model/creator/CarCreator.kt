package racingcar.model.creator

import racingcar.model.Car

interface CarCreator {
    fun createCar(): Car
}
