package game

class Cars private constructor(
    val carList: List<Car>,
    private val moveConditionGenerator: MoveConditionGenerator
) {

    private fun advance() {
        carList.forEach { car ->
            val movement = moveConditionGenerator.generate()
            car.move(movement)
        }
    }

    fun advance(retryCount: Int, action: (List<Car>) -> Unit) = repeat(retryCount) {
        advance()
        carList.let(action)
    }

    companion object {
        fun fromCarCount(carCount: Int, moveConditionGenerator: MoveConditionGenerator): Cars =
            Cars(1.rangeTo(carCount).map { Car() }, moveConditionGenerator)
    }
}
