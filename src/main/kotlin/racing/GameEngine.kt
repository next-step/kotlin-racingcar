package racing

object GameEngine {
    private val randomRange = 0..9
    private const val moveCriteria = 4

    fun playTurnForAllCar(carList: List<Car>) {
        carList.forEach {
            playTurn(it)
        }
    }
    private fun playTurn(car: Car) {
        val diceResult = getRandomNumberBetween(randomRange)
        if (carMoveDecision(diceResult)) car.move()
    }
    private fun getRandomNumberBetween(range: IntRange) = range.random()
    private fun carMoveDecision(number: Int): Boolean = number >= moveCriteria
}
