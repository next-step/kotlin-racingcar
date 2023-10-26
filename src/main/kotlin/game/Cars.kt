package game

class Cars(private val cars: List<Car>) {

    private fun advance() {
        cars.forEach(fun(car: Car) {
            val movement = AdvanceCountGenerator().generateRandomValue()
            car.move(movement)
            val currentPosition = CarPositionRenderer.makePosition(car)
            ConsoleTextPrinter.printText(currentPosition)
        })
        println()
    }

    fun advance(retryCount: Int) = repeat(retryCount) { advance() }

    constructor(cars: Int) : this(1.rangeTo(cars).map { Car() })
}
