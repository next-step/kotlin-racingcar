package com.nextstep.jngcii.racingcar.domain

class Record(private val cars: List<Car>) {
    val eachCarDrivenDistance get() = cars.map { it.distance.toDistanceShape }

    fun goOrStopEachCar(dice: Dice) = cars.forEach {
        if (dice.run()) it.go()
    }

    private val Int.toDistanceShape get() = List(this) { DASH }.joinToString(EMPTY_STRING)

    companion object {
        private const val EMPTY_STRING = ""
        private const val DASH = "-"
    }
}
