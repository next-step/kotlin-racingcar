package racingcar.model.creator

import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.RandomEngine

object RandomEngineCarCreator : CarCreator {
    override fun createCar(carName: CarName): Car {
        return Car(RandomEngine, carName)
    }
}
