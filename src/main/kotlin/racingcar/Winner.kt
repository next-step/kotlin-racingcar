package racingcar

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
        positions: List<NamedPosition>,
        mostPosition: Int
    ) = positions.takeWhile { it >= mostPosition }
        .map { it.name.stringValue() }
}
