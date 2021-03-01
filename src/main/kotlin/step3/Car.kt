package step3

class Car(var position: Int = 0) {
    fun move() {
        position++
    }

    companion object {
        fun makeCars(carCount: Int): List<Car> {
            return (0 until carCount).map { Car() }
        }
    }
}
