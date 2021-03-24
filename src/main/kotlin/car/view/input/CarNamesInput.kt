package car.view.input

data class CarNamesInput(private val names: String) {
    init {
        require(!names.isNullOrBlank()) { "이름은 공백이면 안됩니다." }
    }

    fun splitNameBySplitter(): Array<String> {
        return names.split(NAMES_SPLITTER).toTypedArray()
    }

    companion object {
        private const val NAMES_SPLITTER = ","
    }
}
