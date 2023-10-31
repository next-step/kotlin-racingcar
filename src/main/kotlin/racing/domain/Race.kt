package racing.domain

class Race(private val players: Players, private var gameCount: GameCount, private val movingStrategy: MovingStrategy) {

    val winners: List<CarName>
        get() {
            return players.winners.map { it.name }.toList()
        }

    fun run(): List<Car> {
        players.move(movingStrategy)
        gameCount = gameCount.downCount()
        return players.players
    }

    fun onPlay(): Boolean {
        return gameCount.isLeft
    }
}
