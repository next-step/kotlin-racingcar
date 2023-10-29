package racingcar.model

import racingcar.model.creator.CarCreator

object TrueEngineCarCreator : CarCreator{
    override fun createCar(): Car {
        return Car(TrueEngine)
    }
}
