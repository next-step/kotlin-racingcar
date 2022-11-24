package step3.racingcar.utils

import step3.racingcar.domain.Car

object CarGenerator {
    fun generate(numberOfCar: Int) =
        mutableListOf<Car>().also {
            repeat(numberOfCar) { index -> it.add(Car()) }
        }
}
