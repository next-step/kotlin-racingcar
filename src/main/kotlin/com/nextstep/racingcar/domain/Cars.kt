package com.nextstep.racingcar.domain

import com.nextstep.racingcar.util.isNatural
import kotlin.random.Random

class Cars(numberOfCar: Int) {
    val cars: List<Car>

    init {
        validation(numberOfCar)
        val cars = mutableListOf<Car>()

        for (index in 1..numberOfCar) {
            cars.add(Car())
        }

        this.cars = cars
    }

    fun moveCars() {
        for (car in cars) {
            car.move(Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))
        }
    }

    private fun validation(numberOfCar: Int) {
        if (!numberOfCar.isNatural()) {
            throw IllegalArgumentException("자동차의 수량은 0보다 커야합니다.")
        }
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 10
    }
}
