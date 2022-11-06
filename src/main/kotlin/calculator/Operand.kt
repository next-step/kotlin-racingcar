package calculator

enum class Operand(val symbol: String) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    ;

    companion object {
        fun valueOfSymbol(symbol: String): Operand {
            return when (symbol) {
                "+" -> ADDITION
                "-" -> SUBTRACTION
                "*" -> MULTIPLICATION
                "/" -> DIVISION
                else -> throw IllegalArgumentException("It is not four basic arithmetic operations")
            }
        }
    }

    fun calc(first: Int, second: Int): Int {
        return when (symbol) {
            "+" -> first.plus(second)
            "-" -> first.minus(second)
            "*" -> first.times(second)
            "/" -> first.div(second)
            else -> throw IllegalArgumentException("It is not four basic arithmetic operations")
        }
    }
}
