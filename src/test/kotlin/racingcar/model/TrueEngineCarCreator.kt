package racingcar.model

import racingcar.model.creator.CarCreator

class TrueEngineCarCreator : CarCreator {
    override fun createCar(carName: CarName): Car {
        return Car(TrueEngine, carName)
    }
}
