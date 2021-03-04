package racingcar

class Winner(private val positions: List<Positions>) {
    fun names(): List<String> {
        return positions.last()
            .takeIf { it.isNotEmpty() }
            ?.run {
                winnerNames(this, first().intValue())
            } ?: emptyList()
    }

    private fun winnerNames(
        positions: List<NamedPosition>,
        mostPosition: Int
    ): List<String> = positions
        .sortedByDescending { it.intValue() }
        .takeWhile { it >= mostPosition }
        .map { it.name.stringValue() }
}
