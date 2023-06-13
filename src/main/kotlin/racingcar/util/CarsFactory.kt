package racingcar.util

import racingcar.domain.Car
import racingcar.domain.Cars

object CarsFactory {
    fun createCars(numberGenerator: NumberGenerator, carCount: Int): Cars = Cars(
        Array(carCount) {
            Car(numberGenerator)
        }
    )
}
