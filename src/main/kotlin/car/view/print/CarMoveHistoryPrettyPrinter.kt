package car.view.print

import car.domain.history.CarMoveHistory

class CarMoveHistoryPrettyPrinter(
    private val carMoveHistory: CarMoveHistory,
    private val positionExpression: String = DEFAULT_POSITION_EXPRESSION
) {
    init {
        require(!positionExpression.isNullOrBlank()) { "표시할 문자는 공백이면 안됩니다." }
    }

    override fun toString(): String {
        return "${carMoveHistory.carName} : ${positionExpression.repeat(carMoveHistory.position.value)}"
    }

    companion object {
        const val DEFAULT_POSITION_EXPRESSION = "-"
    }
}
