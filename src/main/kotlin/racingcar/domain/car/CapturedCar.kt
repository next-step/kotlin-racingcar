package racingcar.domain.car

class CapturedCar(
    car: Car
) {
    val name: CarName = car.name
    val position: Int = car.position
}
