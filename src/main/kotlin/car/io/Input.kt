package car.io

data class Input(val name: String, val tryCount: Int) {
    fun splitNameBySplitter(): List<String> {
        return name.split(NAME_SPLITTER)
    }

    companion object {
        val NAME_SPLITTER = ","
    }
}
