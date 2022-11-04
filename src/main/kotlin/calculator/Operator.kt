package calculator

import calculator.Operator.Divide.SYMBOL_DIVIDE
import calculator.Operator.Minus.SYMBOL_MINUS
import calculator.Operator.Multiply.SYMBOL_MULTIPLY
import calculator.Operator.Plus.SYMBOL_PLUS

sealed interface Operator {

    fun operate(num1: Double, num2: Double): Double

    object Plus : Operator {
        const val SYMBOL_PLUS = "+"

        override fun operate(num1: Double, num2: Double): Double {
            TODO("Not yet implemented")
        }
    }

    object Minus : Operator {
        const val SYMBOL_MINUS = "-"

        override fun operate(num1: Double, num2: Double): Double {
            TODO("Not yet implemented")
        }
    }

    object Multiply : Operator {
        const val SYMBOL_MULTIPLY = "*"
        override fun operate(num1: Double, num2: Double): Double {
            TODO("Not yet implemented")
        }
    }

    object Divide : Operator {
        const val SYMBOL_DIVIDE = "/"
        override fun operate(num1: Double, num2: Double): Double {
            TODO("Not yet implemented")
        }
    }

    companion object {
        operator fun invoke(symbol: String): Operator = when (symbol) {
            SYMBOL_PLUS -> Plus
            SYMBOL_MINUS -> Minus
            SYMBOL_MULTIPLY -> Multiply
            SYMBOL_DIVIDE -> Divide
            else -> throw IllegalArgumentException()
        }

        const val OPERATORS = "*+-/"
    }
}