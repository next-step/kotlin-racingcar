package car.domain

data class CarMoveHistory(val carName: CarName, val position: Int) {

    constructor(carName: String, position: Int) : this(CarName(carName), position)

    override fun toString(): String {
        return "${carName.name} : ${POSITION_EXPRESSION.repeat(position)}"
    }

    companion object {
        private const val POSITION_EXPRESSION = "-"
    }
}
