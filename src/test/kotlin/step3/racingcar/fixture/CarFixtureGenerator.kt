package step3.racingcar.fixture

import step3.racingcar.domain.Car

class CarFixtureGenerator {
    companion object {
        fun 경주를_완료한_차량_생성(carName: String, vararg randomNumbers: Int): Car {
            val car = Car(carName)
            randomNumbers.forEach {
                car.race(it)
            }
            return car
        }
    }
}
