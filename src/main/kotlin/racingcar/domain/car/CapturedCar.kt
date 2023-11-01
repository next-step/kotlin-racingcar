package racingcar.domain.car

class CapturedCar(
    val name: CarName,
    val position: Int,
)

fun Car.capture(): CapturedCar = CapturedCar(
    name = this.name,
    position = this.position
)
