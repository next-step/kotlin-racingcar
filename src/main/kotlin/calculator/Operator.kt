package calculator

enum class Operator(val symbol: String) : (Double, Double) -> Double {
    PLUS("+") {
        override fun invoke(a: Double, b: Double): Double = a.plus(b);
    },
    MINUS("-") {
        override fun invoke(a: Double, b: Double): Double = a.minus(b);
    },
    DIV("/") {
        override fun invoke(a: Double, b: Double): Double = a.div(b);
    },
    MULTI("*") {
        override fun invoke(a: Double, b: Double): Double = a.times(b);
    };

    companion object {
        private val store: Map<String, Operator> = Operator.values().associateBy { it.symbol }

        fun of(symbol: String): Operator =
            store[symbol] ?: throw IllegalArgumentException("해당 symbol=$symbol 에 해당하는 연산자가 존재 하지 않습니다.")

        fun exist(symbol: String): Boolean =
            store.containsKey(symbol)
    }
}
