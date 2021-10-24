package racingcar

import racingcar.car.Car
import racingcar.engine.CarEngine
import racingcar.manager.RacingManager

class RacingManagerFactory {
    fun createRacingManager(carNameList: List<String>, engine: CarEngine): RacingManager {
        val cars = carNameList.map { Car(it, carEngine = engine) }
        return RacingManager(cars)
    }
}
