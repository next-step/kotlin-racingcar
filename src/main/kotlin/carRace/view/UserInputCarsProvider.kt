package carRace.view

import carRace.domain.Car
import carRace.domain.CarMovingStrategy
import carRace.domain.CarsProvider

object UserInputCarsProvider : CarsProvider {
    override fun provide(carMovingStrategy: CarMovingStrategy): List<Car> {
        val carNames = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").run {
            readln()
                .trim()
                .split(",")
                .map { it.trim() }
        }
        return carNames.map { Car(it, 0, carMovingStrategy) }
    }
}
