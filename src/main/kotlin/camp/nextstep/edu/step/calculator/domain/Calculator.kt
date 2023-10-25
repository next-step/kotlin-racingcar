package camp.nextstep.edu.step.calculator.domain

import camp.nextstep.edu.step.calculator.command.CalculateCommand

data class Calculator(
    val calculator: CalculateCommand
) {

    /**
     * @description : 사칙연산의 경우, Command 구현체에서 진행하는것이 아닌, Calculator 객체 내에서 계산 후 결과값을 제공하는것이 어떤지 생각했다.
     *
     */
    companion object {
        fun add(leftNumber: Long, rightNumber: Long): Long {
            return leftNumber + rightNumber
        }

        fun subtract(leftNumber: Long, rightNumber: Long): Long {
            return leftNumber - rightNumber
        }

        fun multiply(leftNumber: Long, rightNumber: Long): Long {
            return leftNumber * rightNumber
        }

        fun divide(leftNumber: Long, rightNumber: Long): Long {
            validateDivideByZero(rightNumber)
            return leftNumber / rightNumber
        }

        private fun validateDivideByZero(number: Long) {
            if (number == 0L) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            }
        }
    }

    fun calculateExpression(requester: Requester): Result {
        return calculator.calculate(requester)
    }

}
