package racinggame.domain

class Game(
    val cars: List<RacingCar>,
    private val totalGameTurn: Int,
    private val generator: RandomNumberStrategy,
) {
    private var gameTurn = totalGameTurn

    fun startGame(turnCompleteCallback: ((Int, List<RacingCar>) -> Unit)) {
        while (gameTurn > 0) {
            startTurn()
            turnCompleteCallback(totalGameTurn - gameTurn, cars)
        }
    }

    private fun startTurn() {
        if (checkIsGameStart()) {
            updateGameTurn()
            cars.forEach { car ->
                car.moveCar(generator.generate())
            }
        }
    }

    private fun checkIsGameStart(): Boolean {
        return gameTurn > 0
    }

    private fun updateGameTurn() {
        gameTurn--
    }

    fun getResult(): List<RacingCar> {
        return GameResult.findWinners(cars)
    }

    companion object {
        private const val DELIMITER = ","

        fun createGame(
            carName: String,
            initMoving: Int,
            generator: RandomNumberStrategy = RandomNumberGenerator,
        ): Game {
            val cars = carName.split(DELIMITER).map { RacingCar(it, 0) }
            return Game(cars, initMoving, generator)
        }
    }
}
