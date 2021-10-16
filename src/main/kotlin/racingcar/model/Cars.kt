package racingcar.model

import racingcar.RacingCarMoveMethod

class Cars(
    carCount: CarCount,
    private val racingCarMoveMethod: RacingCarMoveMethod
) {

    private var cars: List<Car> = List(carCount.count) { index -> Car(id = index + 1) }

    fun move() {
        this.cars = cars.map { car -> car.tryMove(racingCarMoveMethod) }
    }

    private fun Car.tryMove(method: RacingCarMoveMethod): Car =
        if (method.isForward()) {
            forward()
        } else {
            backward()
        }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)
}
