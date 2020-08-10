package com.nextstep.racingcar.domain

import kotlin.random.Random

class Cars(val cars: List<Car>) {
    fun moveCars() {
        for (car in cars) {
            car.move(Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))
        }
    }

    fun findWinner(): Cars {
        val maxPosition = cars.map { it.position }.max()
            ?: return Cars(emptyList())

        return Cars(cars.filter { it.isMatchedPosition(maxPosition) })
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 10
    }
}
