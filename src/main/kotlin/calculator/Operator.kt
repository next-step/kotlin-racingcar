package calculator

import java.util.Arrays
import java.util.function.BinaryOperator

enum class Operator(
    private val symbol: String,
    private val binaryOperator: BinaryOperator<Int>
) {
    ADD(
        "+",
        BinaryOperator { x: Int, y: Int -> x + y }
    ),
    SUB(
        "-",
        BinaryOperator { x: Int, y: Int -> x - y }
    ),
    MULTIPLY(
        "*",
        BinaryOperator { x: Int, y: Int -> x * y }
    ),
    DIVIDE(
        "/",
        BinaryOperator { x: Int, y: Int ->
            require(y != 0) { "0으로 나눌 수 없습니다." }
            x / y
        }
    ),
    ;

    fun apply(x: Int, y: Int): Int {
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
