package racingcar.domain.manager

import racingcar.domain.car.Cars
import racingcar.domain.engine.CarEngine

class RacingManagerFactory {
    fun createRacingManager(carNameList: List<String>, engine: CarEngine): RacingManager {
        val cars = Cars.newInstance(carNameList, engine = engine)
        return RacingManager(cars)
    }
}
