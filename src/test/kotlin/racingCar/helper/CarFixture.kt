package racingCar.helper

import racingCar.domain.Car
import racingCar.domain.CarName
import racingCar.util.NumberGenerator

object CarFixture {

    fun makeCars(carCount: Int) = List(carCount) {
        Car(name = CarName("테스트$it"))
    }

    fun makeFakeCarPowerGenerator(power: Int) = object : NumberGenerator {
        override fun generate(): Int {
            return power
        }
    }
}
