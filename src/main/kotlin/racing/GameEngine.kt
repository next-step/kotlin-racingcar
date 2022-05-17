package racing

object GameEngine {
    private val RANDOM_RANGE: IntRange = 0..9
    private const val MOVE_CRITERIA: Int = 4

    fun playTurnForAllCar(carList: List<Car>) {
        carList.forEach {
            playTurn(it, RANDOM_RANGE.random())
        }
    }

    fun playTurn(car: Car, diceResult: Int) {
        if (carMoveDecision(diceResult)) car.move()
    }

    private fun carMoveDecision(number: Int): Boolean = number >= MOVE_CRITERIA
}
