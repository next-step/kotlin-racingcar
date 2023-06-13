package calculator.operationtoken

import calculator.exception.NoSymbolException

sealed class Operator : OperationToken {
    override val isOperator: Boolean = true

    abstract fun execute(operand1: Operand, operand2: Operand): Operand

    companion object {
        fun of(token: String) = when (token) {
            "+" -> Plus(token)
            "-" -> Minus(token)
            "*" -> Multiplication(token)
            "/" -> Division(token)
            else -> throw NoSymbolException("지원하지 않는 연산자입니다.")
        }
    }

    data class Plus(val symbol: String) : Operator() {
        override fun execute(operand1: Operand, operand2: Operand) =
            Operand(operand1.value + operand2.value)
    }

    data class Minus(val symbol: String) : Operator() {
        override fun execute(operand1: Operand, operand2: Operand) =
            Operand(operand1.value - operand2.value)
    }

    data class Multiplication(val symbol: String) : Operator() {
        override fun execute(operand1: Operand, operand2: Operand) =
            Operand(operand1.value * operand2.value)
    }

    data class Division(val symbol: String) : Operator() {
        override fun execute(operand1: Operand, operand2: Operand): Operand {
            if (operand2.value == 0) throw ArithmeticException("0으로 나눌 수 없습니다.")

            return Operand(operand1.value / operand2.value)
        }
    }
}
