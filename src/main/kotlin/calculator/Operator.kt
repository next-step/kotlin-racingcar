package calculator
interface Operator {
    fun calculate(a: Int, b: Int): Int
}

enum class Operation(val symbol: String) : Operator {
    Addition("+") {
        override fun calculate(a: Int, b: Int): Int = a.plus(b)
    },
    Subtraction("-") {
        override fun calculate(a: Int, b: Int): Int = a.minus(b)
    },
    Multiplication("*") {
        override fun calculate(a: Int, b: Int): Int = a.times(b)
    },
    Division("/") {
        override fun calculate(a: Int, b: Int): Int = a.div(b)
    };

    companion object {
        fun symbolToOperator(symbol: String) = when (symbol) {
            "+" -> Addition
            "-" -> Subtraction
            "*" -> Multiplication
            "/" -> Division
            else -> throw InvalidCalculatorInput()
        }
    }
}
