package step2.domain.operation.enums

import step2.domain.operation.command.OperationCommand
import step2.domain.operation.command.implement.AdditionOperationCommand
import step2.domain.operation.command.implement.DivisionOperationCommand
import step2.domain.operation.command.implement.MultiplicationOperationCommand
import step2.domain.operation.command.implement.SubtractionOperationCommand

enum class Operator(
    private val operator: String
) {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/"), EMPTY_STATE("");

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

    fun toCommand(): OperationCommand {
        return when (this) {
            ADDITION -> AdditionOperationCommand
            SUBTRACTION -> SubtractionOperationCommand
            MULTIPLICATION -> MultiplicationOperationCommand
            DIVISION -> DivisionOperationCommand
            EMPTY_STATE -> throw IllegalStateException("연산을 할 수 없는 상태입니다.")
        }
    }
}
