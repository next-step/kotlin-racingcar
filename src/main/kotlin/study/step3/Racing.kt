package study.step3

import study.step3.car.Car

class Racing(private val cars: List<Car>, private val randomNumberGenerator: RandomNumberGenerator) {
    fun play(): List<Int> {
        this.cars
            .forEach { car -> car.move(this.randomNumberGenerator.generate()) }

        return this.cars
            .map { car -> car.currentLocation }
    }
}
