package racingcar

import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.MovingStrategy

object Fixtures {

    fun createCar(movingStrategy: MovingStrategy): Car =
        Car(name = CarName("Car"), position = Car.DEFAULT_POSITION, movingStrategy = movingStrategy)
}