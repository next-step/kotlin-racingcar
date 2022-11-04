package calculator

import calculator.Operator.Divide.SYMBOL_DIVIDE
import calculator.Operator.Minus.SYMBOL_MINUS
import calculator.Operator.Multiply.SYMBOL_MULTIPLY
import calculator.Operator.Plus.SYMBOL_PLUS

sealed interface Operator {

    object Plus : Operator {
        const val SYMBOL_PLUS = "+"
    }

    object Minus : Operator {
        const val SYMBOL_MINUS = "-"
    }

    object Multiply : Operator {
        const val SYMBOL_MULTIPLY = "*"
    }

    object Divide : Operator {
        const val SYMBOL_DIVIDE = "/"
    }

    companion object {
        operator fun invoke(symbol: String): Operator = when (symbol) {
            SYMBOL_PLUS -> Plus
            SYMBOL_MINUS -> Minus
            SYMBOL_MULTIPLY -> Multiply
            SYMBOL_DIVIDE -> Divide
            else -> throw IllegalArgumentException()
        }
    }
}