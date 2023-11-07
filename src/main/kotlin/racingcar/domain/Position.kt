package racingcar.domain

class Position(position: Int = DEFAULT_POSITION){
    var position: Int = position
        private set

    fun forward() {
        position++
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }

    fun equal(other: Position): Boolean {
        return position == other.position
    }
}
