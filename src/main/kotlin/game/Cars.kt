package game

class Cars(
    private val cars: List<Car>,
    private val advanceCountGenerator: AdvanceCountGenerator = AdvanceCountGenerator()
) {

    private fun advance() {
        cars.forEach { car ->
            val movement = advanceCountGenerator.generateRandomValue()
            car.move(movement)
            val currentPosition = CarPositionRenderer.makePosition(car)
            ConsoleTextPrinter.printText(currentPosition)
        }
        println()
    }

    fun advance(retryCount: Int) = repeat(retryCount) { advance() }

    companion object {
        fun fromCarCount(carCount: Int): Cars = Cars(1.rangeTo(carCount).map { Car() })
    }
}
