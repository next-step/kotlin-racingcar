package study.racing.car.factory

import study.racing.car.Car
import study.racing.car.CarList

class NameBasedCarListFactory(
    private val carNames: List<String>
) : CarListFactory {
    override fun create() = CarList(carNames.map { Car(it) })
}
