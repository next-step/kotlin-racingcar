package car.domain.history

import car.domain.CarName

data class CarMoveHistory(val carName: CarName, val position: Int) {
    override fun toString(): String {
        return "${carName.name} : ${DEFAULT_POSITION_EXPRESSION.repeat(position)}"
    }

    companion object {
        const val DEFAULT_POSITION_EXPRESSION = "-"
    }
}
