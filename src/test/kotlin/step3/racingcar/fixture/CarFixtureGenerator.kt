package step3.racingcar.fixture

import step3.racingcar.domain.Car

class CarFixtureGenerator {
    companion object {
        fun 난수를_가지는_차량_생성(carName: String, vararg randomNumbers: Int): Car {
            val car = Car(carName)
            randomNumbers.forEach {
                car.addRandomNumber(it)
            }
            return car
        }

        fun 경주를_완료한_차량_생성(carName: String, vararg randomNumbers: Int): Car {
            val car = Car(carName)
            randomNumbers.forEach {
                car.addRandomNumber(it)
            }
            repeat(randomNumbers.size) {
                car.race(it)
            }
            return car
        }
    }
}
