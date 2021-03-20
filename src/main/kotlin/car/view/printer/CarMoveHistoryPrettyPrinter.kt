package car.view.printer

import car.domain.history.CarMoveHistory

class CarMoveHistoryPrettyPrinter(
    private val carMoveHistory: CarMoveHistory,
    private val positionExpression: String = DEFAULT_POSITION_EXPRESSION
) {
    override fun toString(): String {
        return "${carMoveHistory.carName} : ${positionExpression.repeat(carMoveHistory.position)}"
    }

    companion object {
        const val DEFAULT_POSITION_EXPRESSION = "-"
    }
}
