package racing_car.domain

class RandomAboveThresholdMoveStrategy(
    private val from: Int = 0,
    private val until: Int = 9,
    private val threshold: Int = 4,
) : MoveStrategy {

    override fun canMove(): Boolean {
        val randomNumber = (from..until).random()
        return randomNumber >= threshold
    }
}
