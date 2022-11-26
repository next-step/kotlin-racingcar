package com.jay.racingcar.domain

class Winners(private val racingCars: RacingCars) {
    fun getWinners(): List<RacingCar> {
        val sortedRacingCarsByPosition = racingCars.racingCars.sorted().groupBy { it.getPosition() }.toMap()
        return sortedRacingCarsByPosition.values.first()
    }

    fun getWinnerNames(): List<String> = getWinners().map { it.getNameValue() }
}
