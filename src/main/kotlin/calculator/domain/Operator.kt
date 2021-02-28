package calculator.calculator.domain

enum class Operator(private val symbol: String, private val operate: (Double, Double) -> Double) {
    ADD("+", { prev, next -> prev + next }),
    SUB("-", { prev, next -> prev - next }),
    MUL("*", { prev, next -> prev * next }),
    DIV("/", { prev, next -> prev / next });

    companion object {
        fun from(symbol: String) = values().find { op -> op.symbol == symbol }
            ?: throw IllegalArgumentException("존재하지 않는 기호입니다.")
    }

    fun calculate(prev: Double, next: Double) = operate.invoke(prev, next)
}
