package car.domain

data class CarMoveHistory(val carName: CarName, val position: Int) {
    fun isWinner(winnerPosition: Int): Boolean {
        return position == winnerPosition
    }

    override fun toString(): String {
        return "${carName.name} : ${POSITION_EXPRESSION.repeat(position)}"
    }

    companion object {
        private const val POSITION_EXPRESSION = "-"
    }
}
