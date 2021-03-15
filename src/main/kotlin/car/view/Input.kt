package car.view

data class Input(val name: String, val tryCount: Int, val prettyPositionString: String) {
    fun splitNameBySplitter(): Array<String> {
        return name.split(NAME_SPLITTER).toTypedArray()
    }

    companion object {
        private const val NAME_SPLITTER = ","
    }
}
