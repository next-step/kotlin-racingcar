package study.racing.car.factory

import study.racing.car.Car

class NameBasedCarFactory(
    private val carNames: List<String>
) : CarFactory {
    override fun create() = carNames.map { Car(it) }
}
