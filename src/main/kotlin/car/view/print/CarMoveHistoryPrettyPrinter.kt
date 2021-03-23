package car.view.print

import car.domain.history.CarMoveHistory
import car.view.input.PrettyPrinterInput

class CarMoveHistoryPrettyPrinter(
    carMoveHistory: CarMoveHistory,
    prettyPrinterInput: PrettyPrinterInput = PrettyPrinterInput()
) {
    private val carName = carMoveHistory.carName
    private val expression = prettyPrinterInput.printer
    private val position = carMoveHistory.position.value

    override fun toString(): String {
        return "$carName : ${expression.repeat(position)}"
    }
}
