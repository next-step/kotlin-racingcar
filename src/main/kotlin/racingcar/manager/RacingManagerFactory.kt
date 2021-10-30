package racingcar.manager

import racingcar.car.Cars
import racingcar.engine.CarEngine

class RacingManagerFactory {
    fun createRacingManager(carNameList: List<String>, engine: CarEngine): RacingManager {
        val cars = Cars.newInstance(carNameList, engine = engine)
        return RacingManager(cars)
    }
}
