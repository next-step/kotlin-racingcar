package calculator.operationtoken

import calculator.exception.NoSymbolException

enum class Operator(private val symbol: String) : OperationToken {

    PLUS("+") {
        override fun execute(operand1: Operand, operand2: Operand) =
            Operand(operand1.value + operand2.value)
    },
    MINUS("-") {
        override fun execute(operand1: Operand, operand2: Operand) =
            Operand(operand1.value - operand2.value)
    },
    MULTIPLICATION("*") {
        override fun execute(operand1: Operand, operand2: Operand) =
            Operand(operand1.value * operand2.value)
    },
    DIVISION("/") {
        override fun execute(operand1: Operand, operand2: Operand): Operand {
            if (operand2.value == 0) throw ArithmeticException("0으로 나눌 수 없습니다.")

            return Operand(operand1.value / operand2.value)
        }
    };

    override val isOperator = true
    abstract fun execute(operand1: Operand, operand2: Operand): Operand

    companion object {
        fun of(symbol: String) =
            Operator.values().firstOrNull { it.symbol == symbol }
                ?: throw NoSymbolException("지원하지 않는 연산자입니다.")
    }
}
