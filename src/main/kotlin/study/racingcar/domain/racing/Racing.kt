package study.racingcar.domain.racing

import study.racingcar.domain.car.Car
import study.racingcar.domain.car.Power
import study.racingcar.domain.generator.Generator

class Racing(private val cars: List<Car>, private val generator: Generator) {
    fun round(): List<Record> {
        cars.forEach { car -> car.move(Power(this.generator.generate())) }

        return cars.map { car -> Record(car) }
    }
}
