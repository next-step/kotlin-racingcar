package calculator

import calculator.CalculatorException.CANT_DIVIDE_ZERO_EXCEPTION
import calculator.CalculatorException.IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION

enum class Operator(val op: String, val calculate: (first: Int, second: Int) -> Int) {
    PLUS("+", { first, second ->
        first + second
    }),
    MINUS("-", { first, second ->
        first - second
    }),
    MULTIPLE("*", { first, second ->
        first * second
    }),
    DIVISION("/", { first, second ->
        require(second != 0) { CANT_DIVIDE_ZERO_EXCEPTION }
        first / second
    });

    companion object {
        fun convertToOperator(op: String): Operator {
            return requireNotNull(values().firstOrNull { it.op == op }) { IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION }
        }
    }
}
