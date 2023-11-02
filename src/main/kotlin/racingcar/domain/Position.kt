package racingcar.domain

data class Position(val name: String, val position: Int) : Comparable<Position> {

    override fun compareTo(other: Position): Int {
        return position.compareTo(other.position)
    }
}
