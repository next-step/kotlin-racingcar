package com.racing.step4.domain

class RacingParticipation(
    var cars: List<Car>
) {
    fun turnAround(moveTriggerFunc: () -> Int) {
        cars = cars.map { it.move(moveTriggerFunc) }
            .toList()
    }

    fun findWinner(): List<Car> {
        val largestCar = cars.maxByOrNull { it.position } ?: return listOf()
        return cars.filter { it.position == largestCar.position }
    }

    override fun toString(): String {
        return cars.joinToString("") { it.toString() }
    }
}
