package com.nextstep.jngcii.racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    val winners
        get(): List<Car> {
            val maxDistance = cars.maxOf { it.distance }
            return cars.filter { it.distance == maxDistance }
        }

    fun forEach(action: (car: Car) -> Unit) {
        cars.forEach { action(it) }
    }
}
