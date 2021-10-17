package racingcar.model

import racingcar.RacingCarForwardCondition

/**
 * 현재는 자동차를 index 기반으로 생성하고 있지만
 * 자동차들을 외부에서 주입받아 처리하려면 추상화를 통해 여러개의 Cars 구현체로 가능할 듯
 */
class Cars(
    carNames: List<CarName>,
    private val condition: RacingCarForwardCondition
) {

    private var cars: List<Car> = carNames.map { carName -> Car(carName = carName) }

    val carCount: CarCount = CarCount(carNames.size)

    fun move() {
        this.cars = cars.map { car -> car.tryMove(condition) }
    }

    private fun Car.tryMove(condition: RacingCarForwardCondition): Car =
        if (condition.canForward()) {
            forward()
        } else {
            backward()
        }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)
}
