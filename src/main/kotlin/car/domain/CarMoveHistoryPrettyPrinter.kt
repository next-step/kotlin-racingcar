package car.domain

class CarMoveHistoryPrettyPrinter(
    val carMoveHistory: CarMoveHistory,
    val positionExpression: String = CarMoveHistory.POSITION_EXPRESSION
) {
    override fun toString(): String {
        return "${carMoveHistory.carName.name} : ${positionExpression.repeat(carMoveHistory.position)}"
    }
}
