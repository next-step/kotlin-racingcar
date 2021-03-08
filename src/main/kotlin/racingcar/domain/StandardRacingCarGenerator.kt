package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.CarName
import racingcar.domain.car.engine.RacingEngine

class StandardRacingCarGenerator : RacingCarGenerator {
    override fun generate(name: CarName): Car {
        return Car(name, STANDARD_RACING_ENGINE)
    }

    companion object {
        private val STANDARD_RACING_ENGINE = RacingEngine()
    }
}
