package car.view.input

class PrettyPrinterInput(printer: String? = DEFAULT_POSITION_EXPRESSION) {
    val printer: String

    init {
        require(!printer.isNullOrBlank()) { "표출할 문구는 공백이면 안됩니다." }

        this.printer = printer
    }

    companion object {
        const val DEFAULT_POSITION_EXPRESSION = "-"
    }
}
