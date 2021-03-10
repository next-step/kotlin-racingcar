package car.business

data class CarMoveHistory(val car: Car, val position: Int) {
    override fun toString(): String {
        return "${car.name} : ${POSITION_EXPRESSION.repeat(position)}"
    }

    companion object {
        private const val POSITION_EXPRESSION = "-"
    }
}
