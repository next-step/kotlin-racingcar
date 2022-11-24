package step3.racingcar.utils

import step3.racingcar.domain.Car

object CarGenerator {
    fun generate(carNames: List<String>): MutableList<Car> {
        val cars = mutableListOf<Car>()
        carNames.forEach {
            cars.add(Car(it))
        }
        return cars
    }
}
