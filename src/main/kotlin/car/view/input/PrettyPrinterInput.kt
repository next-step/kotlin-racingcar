package car.view.input

data class PrettyPrinterInput(val printer: String = DEFAULT_POSITION_EXPRESSION) {
    init {
        require(!printer.isNullOrBlank()) { "표출할 문구는 공백이면 안됩니다." }
    }

    companion object {
        private const val DEFAULT_POSITION_EXPRESSION = "-"
    }
}
