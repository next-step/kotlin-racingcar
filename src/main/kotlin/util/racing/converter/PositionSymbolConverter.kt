package util.racing.converter

object PositionSymbolConverter {
    private const val SYMBOL = "-"

    fun converter(position: Int): String {
        return SYMBOL.repeat(position)
    }
}
