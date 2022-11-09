package com.jay.racingcar.domain

class RacingCars(val racingCars: List<RacingCar>) {
    fun play() {
        racingCars.forEach { it.move() }
    }

    companion object {
        fun create(count: Int, movingStrategy: MovingStrategy): RacingCars {
            val cars = mutableListOf<RacingCar>()
            for (i in 0 until count) {
                cars.add(RacingCar(movingStrategy))
            }
            return RacingCars(cars)
        }
    }
}
