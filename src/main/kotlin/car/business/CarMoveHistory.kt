package car.business

data class CarMoveHistory(val carName: String, val position: Int) {
    override fun toString(): String {
        return "$carName : ${POSITION_EXPRESSION.repeat(position)}"
    }

    companion object {
        private const val POSITION_EXPRESSION = "-"
    }
}
