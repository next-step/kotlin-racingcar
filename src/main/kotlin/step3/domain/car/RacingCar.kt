package step3.domain.car

import step3.domain.car.distance.CarDistance
import step3.domain.car.name.CarName

private const val DEFAULT_INIT_DISTANCE = 0

private const val DEFAULT_INCREMENT_DISTANCE = 1

class RacingCar(
    name: String,
    initDistance: Int = DEFAULT_INIT_DISTANCE
) {

    val carName: CarName = CarName(name)

    val carDistance: CarDistance = CarDistance(initDistance)

    fun go() {
        carDistance.increment(DEFAULT_INCREMENT_DISTANCE)
    }
}
