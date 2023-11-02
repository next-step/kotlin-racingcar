package me.parker.nextstep.kotlinracingcar

class Winners(racingCars: List<RacingCar>) {
    val racingCars: List<RacingCar>

    init {
        this.racingCars = racingCars.filter { it -> it.position == racingCars.maxOf { it.position } }
    }
}