package step3.racingcar.fixture

import step3.racingcar.domain.Car

class CarFixtureGenerator {
    companion object {
        fun 난수를_가지는_차량_생성(vararg randomNumbers: Int): Car {
            val car = Car()
            randomNumbers.forEach {
                car.addRandomNumber(it)
            }
            return car
        }
    }
}
