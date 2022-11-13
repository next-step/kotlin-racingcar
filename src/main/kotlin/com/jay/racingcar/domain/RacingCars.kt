package com.jay.racingcar.domain

class RacingCars private constructor(val racingCars: List<RacingCar>) {
    fun play() {
        racingCars.forEach { it.move() }
    }

    companion object {
        fun create(names: Names, movingStrategy: MovingStrategy): RacingCars {
            val cars = mutableListOf<RacingCar>()
            for (i in 0 until names.size()) {
                cars.add(RacingCar(names.get(i), movingStrategy))
            }
            return RacingCars(cars)
        }
    }
}
