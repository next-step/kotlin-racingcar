package car.view

import car.view.input.CarNamesInput
import car.view.input.PrettyPrinterInput
import car.view.input.TryCountInput

class Input(name: CarNamesInput, tryCount: TryCountInput, prettyPositionString: PrettyPrinterInput) {
    val names: String = name.names
    val tryCount: Int = tryCount.count
    val prettyPositionString: String = prettyPositionString.printer

    fun splitNameBySplitter(): Array<String> {
        return names.split(NAME_SPLITTER).toTypedArray()
    }

    companion object {
        private const val NAME_SPLITTER = ","
    }
}
