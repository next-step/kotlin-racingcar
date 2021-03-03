package racingcar

class Positions(private val positions: List<Position>) {
    fun max(): Position {
        return positions.maxBy {
            it.position
        } ?: Position()
    }
}
