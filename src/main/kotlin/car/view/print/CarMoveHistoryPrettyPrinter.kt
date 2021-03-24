package car.view.print

import car.domain.CarName
import car.domain.history.CarMoveHistory

data class CarMoveHistoryPrettyPrinter(
    private val carName: CarName,
    private val expression: String,
    private val position: Int
) {

    constructor(
        carMoveHistory: CarMoveHistory,
        expression: String
    ) : this(
        carMoveHistory.carName,
        expression,
        carMoveHistory.position.value
    )

    override fun toString(): String {
        return "$carName : ${expression.repeat(position)}"
    }
}
