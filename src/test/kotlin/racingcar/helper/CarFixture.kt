package racingcar.helper

import racingcar.domain.Car
import racingcar.util.NumberGenerator

object CarFixture {

    fun makeCars(carCount: Int) = List(carCount) { Car() }

    fun makeFakeCarPowerGenerator(power: Int) = object : NumberGenerator {
        override fun generate(): Int {
            return power
        }
    }
}
