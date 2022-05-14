package racing

object GameEngine {
    private val randomRange = 0..9
    private const val moveCriteria = 4

    fun rollDiceForAllCar(carList: List<Car>) {
        carList.forEach {
            val diceResult = getRandomNumberBetween(randomRange)
            if (carMoveDecision(diceResult)) it.move()
        }
    }
    private fun getRandomNumberBetween(range: IntRange) = range.random()
    private fun carMoveDecision(number: Int): Boolean = number >= moveCriteria
}
