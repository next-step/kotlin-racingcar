package racing

object CarFactory {
    private var sequence: Int = 0

    fun createCar(position: Int = 0): Car {
        return Car.from(sequence++, position)
    }

    fun resetSequence() {
        sequence = 0
    }
}
