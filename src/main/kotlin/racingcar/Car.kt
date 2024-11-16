package racingcar

class Car(
    private val name: CarName,
    private var position: CarPosition,
) {
    fun move() {
        position = position.advance()
    }

    fun getNameValue(): String {
        return name.value
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
