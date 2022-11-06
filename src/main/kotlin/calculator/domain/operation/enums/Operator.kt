package calculator.domain.operation.enums

import calculator.domain.operation.command.OperationCommand
import calculator.domain.operation.command.implement.AdditionOperationCommand
import calculator.domain.operation.command.implement.DivisionOperationCommand
import calculator.domain.operation.command.implement.MultiplicationOperationCommand
import calculator.domain.operation.command.implement.SubtractionOperationCommand

enum class Operator(
    private val operator: String?
) {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/"), EMPTY_OPERATOR(null);

    companion object {
        fun operatorOf(operatorString: String): Operator {
            for (value in values()) {
                if (operatorString == value.operator) {
                    return value
                }
            }
            throw IllegalArgumentException("존재하지 않는 연산자입니다.")
        }
    }

    fun toCommand(): OperationCommand<Int> {
        return when (this) {
            ADDITION -> AdditionOperationCommand
            SUBTRACTION -> SubtractionOperationCommand
            MULTIPLICATION -> MultiplicationOperationCommand
            DIVISION -> DivisionOperationCommand
            EMPTY_OPERATOR -> throw IllegalStateException("연산을 할 수 없는 상태입니다.")
        }
    }
}
