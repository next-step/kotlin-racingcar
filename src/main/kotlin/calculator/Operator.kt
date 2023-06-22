package calculator

import java.math.BigDecimal
import java.util.function.BinaryOperator

enum class Operator(
    private val symbol: String,
    private val binaryOperator: BinaryOperator<BigDecimal>
) {
    ADD(
        "+",
        BinaryOperator { x, y -> x.plus(y) }
    ),
    SUB(
        "-",
        BinaryOperator { x, y -> x.minus(y) }
    ),
    MULTIPLY(
        "*",
        BinaryOperator { x, y -> x.multiply(y) }
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
            return try {
                values().first { v: Operator -> v.symbol == symbol }
            } catch (e: NoSuchElementException) {
                throw InvalidSymbolException("유효한 연산자가 아닙니다. [$symbol]", e)
            }
        }
    }
}
