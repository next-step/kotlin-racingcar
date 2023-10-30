import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

class Operator(val sign: OperatorSymbol) {
    fun operate(first: Int, second: Int): Int = when (sign.op) {
        OperatorSymbol.PLUS_SIGN.op -> first + second
        OperatorSymbol.MINUS_SIGN.op -> first - second
        OperatorSymbol.MULTIPLY_SIGN.op -> first * second
        OperatorSymbol.DIVIDE_SIGN.op -> first / second
        else -> throw IllegalArgumentException("지원하지 않는 연산입니다.")
    }

    sealed class OperatorSymbol(val op: String) {
        object PLUS_SIGN : OperatorSymbol("+")
        object MINUS_SIGN : OperatorSymbol("-")
        object MULTIPLY_SIGN : OperatorSymbol("*")
        object DIVIDE_SIGN : OperatorSymbol("/")

        companion object {
            fun of(op: String): OperatorSymbol {
                return when (op) {
                    PLUS_SIGN.op -> PLUS_SIGN
                    MINUS_SIGN.op -> MINUS_SIGN
                    MULTIPLY_SIGN.op -> MULTIPLY_SIGN
                    DIVIDE_SIGN.op -> DIVIDE_SIGN
                    else -> throw IllegalArgumentException("지원하지 않는 기호입니다.")
                }
            }
        }
    }
}

