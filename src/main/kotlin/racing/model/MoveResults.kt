package racing.model

class MoveResults(val results: List<CarMoveResult>) {
    fun getMaxPositionCarNames(): Names {
        val maxPosition = results.maxOf { it.position }
        val names = results.asSequence()
            .filter { it.position.isMaxPosition(maxPosition) }
            .map { it.name }
            .toList()

        return Names(names)
    }
}
