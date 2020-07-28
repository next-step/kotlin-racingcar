package step3.racing.car

const val CAR_NAME_MAX_LENGTH = 5

class CarImpl(override val name: String) : Car {
    init {
        if (name.length > CAR_NAME_MAX_LENGTH) throw Car.NameLengthOverflowException()
    }

    override var distance = 0

    override fun move() {
        distance++
    }
}
