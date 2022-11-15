package com.jay.racingcar.domain

class Winners(racingCars: RacingCars) {
    private val winners: List<RacingCar>

    init {
        val sortedRacingCarsByPosition = racingCars.racingCars.sorted().groupBy { it.getPosition() }.toMap()
        winners = sortedRacingCarsByPosition.values.first()
    }

    fun getWinners(): List<RacingCar> = winners

    fun getWinnerNames(): List<String> = winners.map { it.getNameValue() }.toList()
}
