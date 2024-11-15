package racing

object CarFactory {
    private var sequence: Int = 0

    fun createCar(position: Int = 0): Car {
        return Car.from(sequence++, position)
    }

    fun createCars(quantity: Int): List<Car> {
        return (0 until quantity).map { createCar() }
    }

    fun resetSequence() {
        sequence = 0
    }
}
