package racingcar.racing

import racingcar.racing.car.Car
import racingcar.racing.car.CarName
import racingcar.racing.car.engine.RacingEngine

class StandardRacingCarGenerator : RacingCarGenerator {
    override fun generate(name: CarName): Car {
        return Car(name, STANDARD_RACING_ENGINE)
    }

    companion object {
        private val STANDARD_RACING_ENGINE = RacingEngine()
    }
}
