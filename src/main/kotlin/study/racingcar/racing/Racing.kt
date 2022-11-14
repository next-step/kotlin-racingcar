package study.racingcar.racing

import study.racingcar.car.Car
import study.racingcar.generator.Generator

class Racing(private val cars: List<Car>, private val generator: Generator) {
    fun attempt(): List<Int> {
        this.cars
            .forEach { car -> car.move(this.generator.generate()) }

        return this.cars
            .map { car -> car.currentLocation }
    }
}
