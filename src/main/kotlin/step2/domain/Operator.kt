package step2.domain

import step2.model.ErrorCode

enum class Operator(private val command: String) {
    PLUS(command = "+") {
        override fun calculate(firstNumber: Double, secondNumber: Double): Double = firstNumber + secondNumber
    },
    MINUS(command = "-") {
        override fun calculate(firstNumber: Double, secondNumber: Double): Double = firstNumber - secondNumber
    },
    MULTIPLY(command = "*") {
        override fun calculate(firstNumber: Double, secondNumber: Double): Double = firstNumber * secondNumber
    },
    DIVIDE(command = "/") {
        private val notAllowedSecondNumber = 0.0

        override fun calculate(firstNumber: Double, secondNumber: Double): Double {
            require(value = secondNumber != notAllowedSecondNumber) {
                ErrorCode.INVALID_NUMBER_INPUT_WHEN_DIVIDE.message(secondNumber.toString())
            }

            return firstNumber / secondNumber
        }
    },
    ;

    abstract fun calculate(firstNumber: Double, secondNumber: Double): Double

    companion object {
        private val COMMAND_MAP = Operator.values()
            .associateBy { it.command }

        fun getOperatorByCommand(command: String): Operator = requireNotNull(value = COMMAND_MAP[command]) {
            ErrorCode.INVALID_OPERATOR_CODE.message(command)
        }
    }
}
