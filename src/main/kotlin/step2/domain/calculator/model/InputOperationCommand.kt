package step2.domain.calculator.model

import step2.domain.operation.enums.Operator

data class InputOperationCommand(
    val number: Int,
    val nextOperator: Operator
)
