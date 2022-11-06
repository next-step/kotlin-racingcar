package calculator.domain.calculator.model

import calculator.domain.operation.enums.Operator

data class InputOperationCommand(
    val number: Int,
    val nextOperator: Operator
)
