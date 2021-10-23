package racingcar

import racingcar.car.Car
import racingcar.engine.CarEngine
import racingcar.manager.RacingManager

class RacingManagerFactory {
    fun createRacingManager(numberOfCars: Int, engine: CarEngine): RacingManager {
        val cars = (0 until numberOfCars).map { Car() }
        return RacingManager(cars, engine)
    }
}
