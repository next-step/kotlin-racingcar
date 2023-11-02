package me.parker.nextstep.kotlinracingcar

class Winners(racingCars: List<RacingCar>) {
    val winners: List<RacingCar>

    init {
        winners = racingCars.filter { it -> it.position == racingCars.maxOf { it.position } }
    }
}