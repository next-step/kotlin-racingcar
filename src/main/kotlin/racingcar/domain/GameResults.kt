package racingcar.domain

data class GameResults(val positions: List<Positions>) {
    val winners: List<String>
        get() = winners()

    private fun winners(): List<String> {
        val lastPositions = positions.last().values
        val winnerPosition = lastPositions.max()
        return lastPositions
            .filter { winnerPosition.position == it.position }
            .map { it.name }
    }

    companion object {
        fun create(vararg  positions: Positions): GameResults {
            return GameResults(positions.toList())
        }
    }
}
