package step1.calculator

enum class OperationType(private val operator: String) {
    PLUS("+") {
        override fun calculate(t: Double, u: Double): Double = t + u
    },
    MINUS("-") {
        override fun calculate(t: Double, u: Double): Double = t - u
    },
    MULTIPLY("*") {
        override fun calculate(t: Double, u: Double): Double = t * u
    },
    DIVIDE("/") {
        override fun calculate(t: Double, u: Double): Double = t / u
    };

    abstract fun calculate(t: Double, u: Double): Double

    companion object {
        fun match(operator: String): OperationType = values().first { it.operator == operator }
    }
}
