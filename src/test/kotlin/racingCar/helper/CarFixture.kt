package racingCar.helper

import racingCar.domain.Car
import racingCar.domain.CarName
import racingCar.domain.CarPosition
import racingCar.util.NumberGenerator

object CarFixture {

    fun makeCar(name: String, position: Int): Car =
        Car(name = CarName(name), position = CarPosition(position))

    fun makeCars(carCount: Int) = List(carCount) {
        Car(name = CarName("테스트$it"))
    }

    fun makeFakeCarPowerGenerator(power: Int) = object : NumberGenerator {
        override fun generate(): Int {
            return power
        }
    }
}
