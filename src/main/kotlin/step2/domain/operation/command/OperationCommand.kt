package step2.domain.operation.command

import step2.domain.operation.model.InputOperationCommand

interface OperationCommand {
    fun operate(input: InputOperationCommand): Int
}
