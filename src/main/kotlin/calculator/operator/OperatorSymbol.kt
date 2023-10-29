package calculator.operator

enum class OperatorSymbol(private val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/")
    ;

    companion object {
        fun isPlus(symbol: String): Boolean {
            return symbol == PLUS.symbol
        }

        fun isMinus(symbol: String): Boolean {
            return symbol == MINUS.symbol
        }

        fun isMultiply(symbol: String): Boolean {
            return symbol == MULTIPLY.symbol
        }

        fun isDivide(symbol: String): Boolean {
            return symbol == DIVIDE.symbol
        }
    }
}
