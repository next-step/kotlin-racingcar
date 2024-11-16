package racingcar

class Car(
    val name: CarName,
    private var position: CarPosition,
) {
    fun move() {
        position = position.advance()
    }

    fun getPositionValue(): Int {
        return position.value
    }

    companion object {
        fun makeNewCar(name: String): Car {
            return Car(CarName(name), CarPosition.startPosition())
        }
    }
}
