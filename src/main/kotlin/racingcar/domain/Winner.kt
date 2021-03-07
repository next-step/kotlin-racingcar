package racingcar.domain

class Winner(private val positions: List<Positions>) {
    fun names(): List<String> {
        return positions.last()
            .sortedByDescending { it.intValue() }
            .takeIf { it.isNotEmpty() }
            ?.run {
                winnerNames(this, first().intValue())
            } ?: emptyList()
    }

    private fun winnerNames(
        positions: List<Position>,
        mostPosition: Int
    ): List<String> = positions
        .filter { it >= mostPosition }
        .map { it.name.stringValue() }
}
