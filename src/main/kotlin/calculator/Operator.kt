package calculator

import java.util.Arrays

enum class Operator(
    private val symbol: String,
    private val function: (a: Int, b: Int) -> Int
) {

    ADDITION("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b }),
    ;

    fun operate(a: Int, b: Int): Int {
        return function.invoke(a, b)
    }

    companion object {
        fun of(symbol: String): Operator {
            return Arrays.stream(values())
                .filter { operator -> operator.symbol == symbol } // 코틀린에서는 equals 비교가 ==
                .findFirst()
                .orElseThrow { IllegalArgumentException("지원하지 않는 연산자 입니다. ($symbol)") }
        }
    }
}