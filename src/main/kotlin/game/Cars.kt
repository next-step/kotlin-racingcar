package game

class Cars private constructor(
    private val cars: List<Car>,
    private val moveConditionGenerator: MoveConditionGenerator
) {

    private fun advance() {
        cars.forEach { car ->
            val movement = moveConditionGenerator.generate()
            car.move(movement)
            val currentPosition = CarPositionRenderer.makePosition(car)
            ConsoleTextPrinter.printText(currentPosition)
        }
        println()
    }

    fun advance(retryCount: Int) = repeat(retryCount) { advance() }

    companion object {
        fun fromCarCount(carCount: Int, moveConditionGenerator: MoveConditionGenerator): Cars =
            Cars(1.rangeTo(carCount).map { Car() }, moveConditionGenerator)
    }
}
