package racing.domain

class Players(val players: List<Car>) {

    constructor(playerCount: Int) : this(createPlayerList(playerCount))

    companion object {
        private fun createPlayerList(playerCount: Int): List<Car> {
            return List(playerCount) { Car() }
        }
    }

    fun move(movingStrategy: MovingStrategy?) {
        for (player in players) {
            player.move(movingStrategy!!)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Players

        return players == other.players
    }

    override fun hashCode(): Int {
        return players.hashCode()
    }
}
