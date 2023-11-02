package racing.domain

class Players(val players: List<Car>) {

    val winners: List<Car>
        get() {
            val maxLocation = players.maxOf { it.location.location }
            return players.filter { it.location.location == maxLocation }
        }

    constructor(players: String) : this(createPlayerList(players))

    companion object {
        private const val PLAYER_SEPARATOR = ","

        private fun createPlayerList(players: String): List<Car> {
            val split = players.split(PLAYER_SEPARATOR)
            return split.map { name -> Car(CarName(name)) }.toList()
        }
    }

    fun move(movingStrategy: MovingStrategy) {
        for (player in players) {
            player.move(movingStrategy)
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
