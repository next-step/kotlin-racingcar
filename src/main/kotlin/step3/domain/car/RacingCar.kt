package step3.domain.car

import step3.domain.car.distance.CarDistance
import step3.domain.car.distance.DefaultCarDistance
import step3.domain.car.name.CarName

private const val DEFAULT_INIT_DISTANCE = 0

private const val DEFAULT_INCREMENT_DISTANCE = 1

class RacingCar(
    carName: String,
    initDistance: Int = DEFAULT_INIT_DISTANCE
) {

    private val carName: CarName = CarName(carName)

    private val carDistance: CarDistance<Int> = DefaultCarDistance(initDistance)

    val name: String
        get() = carName.name

    val distance: Int
        get() = carDistance.distance

    fun go() {
        carDistance.increment(DEFAULT_INCREMENT_DISTANCE)
    }
}
