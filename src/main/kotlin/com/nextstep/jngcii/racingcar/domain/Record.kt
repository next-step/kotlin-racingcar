package com.nextstep.jngcii.racingcar.domain

class Record(private val cars: List<Car>) {
    val eachCarDistance get() = cars.map { it.distance }

    fun goOrStopEachCar(dice: Dice) = cars.forEach {
        if (dice.run()) it.go()
    }
}
