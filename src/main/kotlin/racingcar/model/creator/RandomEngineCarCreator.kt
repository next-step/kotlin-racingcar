package racingcar.model.creator

import racingcar.model.Car
import racingcar.model.RandomEngine

object RandomEngineCarCreator : CarCreator {
    override fun createCar(): Car {
        return Car(RandomEngine)
    }
}
