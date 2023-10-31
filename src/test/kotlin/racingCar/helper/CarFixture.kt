package racingCar.helper

import racingCar.domain.Car
import racingCar.util.NumberGenerator

object CarFixture {

    fun makeCars(carCount: Int) = List(carCount) { Car() }

    fun makeFakeCarPowerGenerator(power: Int) = object : NumberGenerator {
        override fun generate(): Int {
            return power
        }
    }
}
