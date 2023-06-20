package calculator

import java.math.BigDecimal
import java.util.*
import java.util.function.BinaryOperator

enum class Operator(
    private val symbol: String,
    private val binaryOperator: BinaryOperator<BigDecimal>
) {
    ADD(
        "+",
        BinaryOperator { x, y -> x + y }
    ),
    SUB(
        "-",
        BinaryOperator { x, y -> x - y }
    ),
    MULTIPLY(
        "*",
        BinaryOperator { x, y -> x * y }
    ),
    DIVIDE(
        "/",
        BinaryOperator { x, y ->
            require(y != BigDecimal.ZERO) { "0으로 나눌 수 없습니다." }
            x.divide(y)
        }
    ),
    ;

    fun apply(x: BigDecimal, y: BigDecimal): BigDecimal {
        return binaryOperator.apply(x, y)
    }

    companion object {
        fun from(symbol: String): Operator {
            return Arrays.stream(values())
                .filter { v: Operator -> v.symbol == symbol }
                .findAny()
                .orElseThrow { InvalidSymbolException("유효한 연산자가 아닙니다. [$symbol]") }
        }
    }
}
