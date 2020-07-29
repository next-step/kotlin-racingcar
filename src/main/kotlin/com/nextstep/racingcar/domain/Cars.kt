package com.nextstep.racingcar.domain

import kotlin.random.Random

class Cars(numberOfCar: Int) {
    private val cars: List<Car>

    init {
        validation(numberOfCar)
        val cars = mutableListOf<Car>()

        for (index in 0..numberOfCar) {
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

    private fun Int.isNatural(): Boolean {
        return this > 0
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 10
    }
}
