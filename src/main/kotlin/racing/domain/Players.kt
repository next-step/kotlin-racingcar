package racing.domain

data class Players(val players: List<Car>) {

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
}
