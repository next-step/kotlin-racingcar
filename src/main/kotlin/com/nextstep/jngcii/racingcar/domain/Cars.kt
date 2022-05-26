package com.nextstep.jngcii.racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    constructor(names: List<String>, dice: Dice) : this(
        cars = names.map { Car(name = it, dice = dice) }
    )

    val nameToDistanceMap
        get() = cars.associate {
            it.name to it.distance
        }

    val winners
        get(): List<Car> {
            val maxDistance = cars.maxOf { it.distance }
            return cars.filter { it.distance == maxDistance }
        }

    fun forEach(action: (car: Car) -> Unit) {
        cars.forEach { action(it) }
    }
}
