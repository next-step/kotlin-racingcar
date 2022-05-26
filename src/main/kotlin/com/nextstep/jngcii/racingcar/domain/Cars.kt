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

    fun getNames(distance: Int) = cars
        .filter { it.distance == distance }
        .map { it.name }

    fun forEach(action: (car: Car) -> Unit) {
        cars.forEach { action(it) }
    }
}
