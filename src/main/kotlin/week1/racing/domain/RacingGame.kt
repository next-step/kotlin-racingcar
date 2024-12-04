package week1.racing.domain

class RacingGame(
    carNames: List<String>,
    private val numRounds: Int,
    private val carMovementDecider: MovementDecider = CarMovementDecider(),
) {
    private val winner = RacingGameWinner()
    private val cars = carNames.map { name -> RacingCar(name, carMovementDecider) }
    private val _gameRounds = mutableListOf<GameRound>()
    val gameRounds: List<GameRound> = _gameRounds

    init {
        require(cars.isNotEmpty() && numRounds > 0) {
            "Game cannot be started! (cars.size = ${cars.size}, numRounds = $numRounds)"
        }
    }

    fun start() {
        repeat(numRounds) {
            startRound()
        }
    }

    fun getWinner(): List<RacingCar> {
        return winner.getWinners(cars)
    }

    private fun startRound() {
        val list = mutableListOf<GameRoundRecord>()
        cars.forEach { car ->
            car.moveForward()
            list.add(GameRoundRecord(car.name, car.currentPosition))
        }
        _gameRounds.add(GameRound(records = list))
    }
}

data class GameRound(
    val records: List<GameRoundRecord>,
)

data class GameRoundRecord(
    val name: String,
    val distance: Int,
)
