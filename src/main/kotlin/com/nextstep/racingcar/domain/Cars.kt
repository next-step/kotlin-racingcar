package com.nextstep.racingcar.domain

import com.nextstep.racingcar.util.isNatural
import kotlin.random.Random

class Cars(carName: String) {
    val cars: List<Car>

    init {
        val carNames = carName.split(",")
        validation(carNames)

        this.cars = carNames.map { Car(it) }
    }

    fun moveCars() {
        for (car in cars) {
            car.move(Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))
        }
    }

    private fun validation(carNames: List<String>) {
        if (!carNames.size.isNatural()) {
            throw IllegalArgumentException("자동차의 수량은 0보다 커야합니다.")
        }
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 10
    }
}
