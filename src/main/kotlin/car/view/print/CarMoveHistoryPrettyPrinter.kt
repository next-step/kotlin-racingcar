package car.view.print

import car.domain.CarName
import car.domain.history.CarMoveHistory
import car.view.input.PrettyPrinterInput

data class CarMoveHistoryPrettyPrinter(
    private val carName: CarName,
    private val expression: String,
    private val position: Int
) {

    constructor(
        carMoveHistory: CarMoveHistory,
        prettyPrinterInput: PrettyPrinterInput = PrettyPrinterInput()
    ) : this(
        carMoveHistory.carName,
        prettyPrinterInput.printer,
        carMoveHistory.position.value
    )

    override fun toString(): String {
        return "$carName : ${expression.repeat(position)}"
    }
}
