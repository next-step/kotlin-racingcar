package car.view.input

class PrettyPrinterInput(printer: String? = DEFAULT_POSITION_EXPRESSION) {
    val printer: String

    init {
        require(!printer.isNullOrBlank()) { "표출할 문구는 공백이면 안됩니다." }

        this.printer = printer
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PrettyPrinterInput

        if (printer != other.printer) return false

        return true
    }

    override fun hashCode(): Int {
        return printer.hashCode()
    }

    companion object {
        private const val DEFAULT_POSITION_EXPRESSION = "-"
    }
}
