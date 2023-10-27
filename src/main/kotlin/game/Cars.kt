package game

class Cars private constructor(
    private val cars: List<Car>, private val moveConditionGenerator: MoveConditionGenerator
) {

    private fun advance() {
        cars.forEach { car ->
            val movement = moveConditionGenerator.generate()
            car.move(movement)
        }
    }

    fun advance(retryCount: Int) = repeat(retryCount) {
        advance();
        UserMessageDisplay.display(cars)
    }

    companion object {
        fun fromCarCount(carCount: Int, moveConditionGenerator: MoveConditionGenerator): Cars =
            Cars(1.rangeTo(carCount).map { Car() }, moveConditionGenerator)
    }
}
