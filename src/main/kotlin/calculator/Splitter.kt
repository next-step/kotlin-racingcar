package calculator

object Splitter {
    fun getSymbols(source: String): List<String> =
        source.split(" ")
            .filter {
                isInt(it)
            }

    fun getNumbers(source: String): List<Int> =
        source.split(" ")
            .filterNot {
                isInt(it)
            }
            .map {
                it.toInt()
            }

    private fun isInt(value: String): Boolean {
        return value.toIntOrNull() == null
    }
}
