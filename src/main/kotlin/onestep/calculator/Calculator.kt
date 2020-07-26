package onestep.calculator

object Calculator {
    enum class Operator(val opStr: String, val operatorFun: (a: Double, b: Double) -> Double) {
        PLUS("+", { a, b -> a + b }),
        MINUS("-", { a, b -> a - b }),
        MULTIPLY("*", { a, b -> a * b }),
        DIVISION("/", { a, b -> a / b });
    }

    private fun getOperator(opStr: String) =
        when (opStr) {
            Operator.PLUS.opStr -> Operator.PLUS
            Operator.MINUS.opStr -> Operator.MINUS
            Operator.MULTIPLY.opStr -> Operator.MULTIPLY
            Operator.DIVISION.opStr -> Operator.DIVISION
            else -> {
                throw IllegalArgumentException("Unknown Operator")
            }
        }

    fun calculate(first: Double, opStr: String, second: Double) =
        getOperator(opStr).run {
            if (this == Operator.DIVISION && second.isZero()) {
                throw IllegalArgumentException("Can not DIVISION Zero")
            }
            this.operatorFun(first, second)
        }
}

internal fun Double.isZero() = this == 0.0
