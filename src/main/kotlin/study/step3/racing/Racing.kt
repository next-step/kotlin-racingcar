package study.step3.racing

import study.step3.car.Car
import study.step3.generator.Generator

class Racing(private val cars: List<Car>, private val generator: Generator) {
    fun attempt(): List<Int> {
        this.cars
            .forEach { car -> car.move(this.generator.generate()) }

        return this.cars
            .map { car -> car.currentLocation }
    }
}
