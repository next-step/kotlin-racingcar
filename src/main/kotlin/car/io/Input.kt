package car.io

import java.lang.IllegalArgumentException

data class Input(val name: String, val tryCount: Int) {
    init {
        val maxLengthName = splitNameBySplitter().maxBy { it.length } ?: throw IllegalArgumentException()
        require(maxLengthName.length <= 5)
    }

    fun splitNameBySplitter(): List<String> {
        return name.split(NAME_SPLITTER)
    }

    companion object {
        const val NAME_SPLITTER = ","
    }
}
