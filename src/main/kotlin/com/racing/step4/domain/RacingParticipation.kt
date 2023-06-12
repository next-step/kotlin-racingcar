package com.racing.step4.domain

class RacingParticipation {
    var cars: List<Car> = emptyList<Car>()
        private set(value) {
            field = value.toList()
        }

    constructor(participationNames: List<String>) {
        cars = participationNames.map { Car(it) }
    }

    fun turnAround(moveTriggerFunc: () -> Int) {
        cars = cars.map { it.move(moveTriggerFunc) }
    }

    fun findWinner(): List<Car> {
        val largestCar = cars.maxByOrNull { it.position } ?: return emptyList()
        return cars.filter { it.position == largestCar.position }
    }
}
