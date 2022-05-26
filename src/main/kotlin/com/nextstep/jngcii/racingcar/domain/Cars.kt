package com.nextstep.jngcii.racingcar.domain

class Cars(
    vararg _cars: Car
) {
    constructor(names: List<String>, dice: Dice) : this(
        _cars = names
            .map { Car(name = it, dice = dice) }
            .toTypedArray()
    )

    private val cars: List<Car> = _cars.toList()

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
