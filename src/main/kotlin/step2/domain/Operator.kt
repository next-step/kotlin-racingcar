package step2.domain

import step2.model.ErrorCode

enum class Operator(private val command: String) {
    PLUS(command = "+") {
        override fun calculate(firstNumber: Long, secondNumber: Long): Long = firstNumber + secondNumber
    },
    MINUS(command = "-") {
        override fun calculate(firstNumber: Long, secondNumber: Long): Long = firstNumber - secondNumber
    },
    MULTIPLY(command = "*") {
        override fun calculate(firstNumber: Long, secondNumber: Long): Long = firstNumber * secondNumber
    },
    DIVIDE(command = "/") {
        override fun calculate(firstNumber: Long, secondNumber: Long): Long = firstNumber / secondNumber
    },
    ;

    abstract fun calculate(firstNumber: Long, secondNumber: Long): Long

    companion object {
        private val COMMAND_MAP = Operator.values()
            .associateBy { it.command }

        fun getOperatorByCommand(command: String): Operator = requireNotNull(value = COMMAND_MAP[command]) {
            ErrorCode.INVALID_OPERATOR_CODE.message(command)
        }
    }
}
