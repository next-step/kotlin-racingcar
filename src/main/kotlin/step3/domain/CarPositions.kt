package step3.domain

class CarPositions(private val positions: List<CarPosition>) {
    fun moveBy(movable: () -> Boolean): CarPositions {
        val positions = this.positions.map { if (movable()) it.move() else it }
        return CarPositions(positions)
    }

    fun getPositions(): List<Int> = this.positions.map { it.position }

    companion object {
        fun of(size: Int, initialPosition: Int = 0): CarPositions {
            val carPositions = List(size) { CarPosition(initialPosition) }
            return CarPositions(carPositions)
        }
    }
}
