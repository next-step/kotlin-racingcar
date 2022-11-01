package step2.domain.operation.command

import step2.domain.operation.model.InputOperationCommand

class DefaultOperationCommand : OperationCommand {
    override fun operate(input: InputOperationCommand) = 1
}
