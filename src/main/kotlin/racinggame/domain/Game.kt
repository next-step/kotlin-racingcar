package racinggame.domain

class Game(val cars: List<RacingCar>, val totalGameTurn: Int) {
    private var gameTurn = totalGameTurn

    fun startTurn() {
        if (checkIsGameStart()) {
            updateGameTurn()
            cars.forEach { car ->
                car.moveCar(RandomNumberGenerator.create())
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
        ): Game {
            val cars = carName.split(DELIMITER).map { RacingCar(it, 0) }
            return Game(cars, initMoving)
        }
    }
}
