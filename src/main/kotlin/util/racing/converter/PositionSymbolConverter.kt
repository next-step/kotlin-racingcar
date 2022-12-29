package util.racing.converter

class PositionSymbolConverter private constructor() {

    companion object {
        private const val SYMBOL = "-"
        fun converter(position: Int): String {
            return SYMBOL.repeat(position)
        }
    }
}
